package com.github.wolfiewaffle.hardcoretorches.client.render.items;

import com.github.wolfiewaffle.hardcoretorches.HardcoreTorches;
import com.github.wolfiewaffle.hardcoretorches.blocks.ModBlocks;
import com.github.wolfiewaffle.hardcoretorches.items.ModItems;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ItemRenderRegister {
	public static String modid = HardcoreTorches.MODID;

    public static void registerItemRenderer() {
    	ModelLoader.setCustomModelResourceLocation(ModItems.animal_fat, 0, new ModelResourceLocation("hardcoretorches:animal_fat", "inventory"));
    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.torch_burnt), 0, new ModelResourceLocation("hardcoretorches:torch_burnt", "inventory"));
    }

	public static void reg(Item item, String name) {
	}
}
