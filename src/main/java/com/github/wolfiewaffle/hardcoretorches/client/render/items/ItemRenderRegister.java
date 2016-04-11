package com.github.wolfiewaffle.hardcoretorches.client.render.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.github.wolfiewaffle.hardcoretorches.HardcoreTorches;
import com.github.wolfiewaffle.hardcoretorches.items.ModItems;


public class ItemRenderRegister {
	public static String modid = HardcoreTorches.MODID;

    public static void registerItemRenderer() {
    	reg(ModItems.animal_fat);
    }

	public static void reg(Item item) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    	.register(item, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
