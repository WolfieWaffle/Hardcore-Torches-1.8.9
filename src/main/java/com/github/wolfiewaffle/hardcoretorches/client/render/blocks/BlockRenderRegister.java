package com.github.wolfiewaffle.hardcoretorches.client.render.blocks;

import com.github.wolfiewaffle.hardcoretorches.HardcoreTorches;
import com.github.wolfiewaffle.hardcoretorches.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class BlockRenderRegister {
	public static String modid = HardcoreTorches.MODID;

    public static void registerBlockRenderer() {
    	reg(ModBlocks.torch_burnt, "torch_burnt");
    	reg(ModBlocks.torch_lit, "torch_lit");
    }

	public static void reg(Block block, String name) {
		// This sets the custom model for a (registry ID? block?)
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(HardcoreTorches.MODID, name), "inventory"));
	}
}
