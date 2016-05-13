package com.github.wolfiewaffle.hardcoretorches.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	public static Block torch_burnt;

    public static void createBlocks() {
    	GameRegistry.registerBlock(torch_burnt = new BlockTorchBurnt("torch_burnt"), "torch_burnt");
    }
}
