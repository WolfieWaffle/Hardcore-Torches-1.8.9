package com.github.wolfiewaffle.hardcoretorches;

import com.github.wolfiewaffle.hardcoretorches.proxy.CommonProxy;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = HardcoreTorches.MODID, name = HardcoreTorches.MODNAME, version = HardcoreTorches.VERSION)
public class HardcoreTorches {
    public static final String MODID = "hardcoretorches";
    public static final String MODNAME = "Hardcore Torches";
    public static final String VERSION = "@VERSION@";

    // Config options
    public static int configTorchFuel;
    public static boolean configDebug;
    public static int configTorchDropMode;

    @SidedProxy(clientSide="com.github.wolfiewaffle.hardcoretorches.proxy.ClientProxy", serverSide="com.github.wolfiewaffle.hardcoretorches.proxy.ServerProxy")
    public static CommonProxy proxy;

    // Instance so we can refer to the mod later
    @Instance
    public static HardcoreTorches instance = new HardcoreTorches();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		HardcoreTorches.proxy.preInit(event);

		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		configTorchFuel = config.getInt("torchFuel", Configuration.CATEGORY_GENERAL, 1000, 1, Integer.MAX_VALUE, "Burn time (in seconds) of a default lit torch");
		configDebug = config.getBoolean("debug", Configuration.CATEGORY_GENERAL, false, "Set to true to output debug info to the console. Not useful for players.");
		configTorchDropMode = config.getInt("torchDropMode", Configuration.CATEGORY_GENERAL, 0, 0, 2, "0: Torches burn out completely when broken.\n1: Torches will become unlit when broken.\n2: Torches will stay lit when broken.");

		config.save();
	}

	@EventHandler
	public void Init(FMLInitializationEvent event) {
		HardcoreTorches.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		HardcoreTorches.proxy.postInit(event);
	}
}
