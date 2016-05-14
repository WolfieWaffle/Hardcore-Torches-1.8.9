package com.github.wolfiewaffle.hardcoretorches.client.render.items;

import com.github.wolfiewaffle.hardcoretorches.HardcoreTorches;
import com.github.wolfiewaffle.hardcoretorches.blocks.ModBlocks;
import com.github.wolfiewaffle.hardcoretorches.items.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ItemRenderRegister {
	public static String modid = HardcoreTorches.MODID;

    public static void registerItemRenderer() {
    	//reg(ModItems.animal_fat, "animal_fat");
    	//reg(Item.getItemFromBlock(ModBlocks.torch_burnt), "torch_burnt");
    	//ModelLoader.setCustomModelResourceLocation(ModItems.animal_fat, 0, new ModelResourceLocation(new ResourceLocation(HardcoreTorches.MODID, "item/animal_fat"), "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ModItems.animal_fat, 0, new ModelResourceLocation("hardcoretorches:animal_fat", "inventory"));
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(ModBlocks.torch_burnt), 0, new ModelResourceLocation("hardcoretorches:torch_burnt", "inventory"));
    }

	public static void reg(Item item, String name) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(HardcoreTorches.MODID, "item/" + name), "inventory"));
		// Debug
		System.out.println("###############");
		System.out.println(item + ", " + name);
		System.out.println("###############");
	}
}
