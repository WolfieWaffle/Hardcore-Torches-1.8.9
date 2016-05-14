package com.github.wolfiewaffle.hardcoretorches.proxy;

import com.github.wolfiewaffle.hardcoretorches.blocks.ModBlocks;
import com.github.wolfiewaffle.hardcoretorches.items.ModItems;
import com.github.wolfiewaffle.tileentity.ModTileEntities;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
    	ModItems.createItems();
    	ModBlocks.createBlocks();
    	ModTileEntities.init();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
