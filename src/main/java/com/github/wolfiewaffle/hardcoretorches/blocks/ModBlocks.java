package com.github.wolfiewaffle.hardcoretorches.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {
	public static Block torch_burnt;
	public static Block torch_lit;

    public static void createBlocks() {
    	GameRegistry.registerBlock(torch_burnt = new BlockTorchBurnt("torch_burnt"), "torch_burnt");
    	GameRegistry.registerBlock(torch_lit = new BlockTorchLit("torch_lit"), "torch_lit");
    }
}
