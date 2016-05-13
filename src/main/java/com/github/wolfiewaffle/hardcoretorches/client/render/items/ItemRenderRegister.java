package com.github.wolfiewaffle.hardcoretorches.client.render.items;

import com.github.wolfiewaffle.hardcoretorches.HardcoreTorches;
import com.github.wolfiewaffle.hardcoretorches.blocks.ModBlocks;
import com.github.wolfiewaffle.hardcoretorches.items.ModItems;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ItemRenderRegister {
	public static String modid = HardcoreTorches.MODID;

    public static void registerItemRenderer() {
    	reg(ModItems.animal_fat);
    	reg(Item.getItemFromBlock(ModBlocks.torch_burnt));
    }

	public static void reg(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(HardcoreTorches.MODID, "burnt_torch"), "inventory"));
	}
}
