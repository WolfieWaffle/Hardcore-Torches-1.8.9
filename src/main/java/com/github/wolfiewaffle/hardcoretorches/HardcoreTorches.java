package com.github.wolfiewaffle.hardcoretorches;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.github.wolfiewaffle.hardcoretorches.client.render.items.ItemRenderRegister;
import com.github.wolfiewaffle.hardcoretorches.proxy.CommonProxy;

@Mod(modid = HardcoreTorches.MODID, name = HardcoreTorches.MODNAME, version = HardcoreTorches.VERSION)
public class HardcoreTorches {
    public static final String MODID = "hardcoretorches";
    public static final String MODNAME = "Hardcore Torches";
    public static final String VERSION = "@VERSION@";

    @SidedProxy(clientSide="com.github.wolfiewaffle.hardcoretorches.proxy.ClientProxy", serverSide="com.github.wolfiewaffle.hardcoretorches.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Instance
    public static HardcoreTorches instance = new HardcoreTorches();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		HardcoreTorches.proxy.preInit(event);
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
