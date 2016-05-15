package com.github.wolfiewaffle.hardcoretorches.items;

import com.github.wolfiewaffle.hardcoretorches.blocks.ModBlocks;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {
	public static Item animal_fat;
	public static ItemBlock torch_lit;

    public static void createItems() {
    	GameRegistry.registerItem(animal_fat = new BasicItem("animal_fat"), "animal_fat");
    	GameRegistry.registerItem(torch_lit = new ItemTorchLit(ModBlocks.torch_lit), "torch_lit");
    }
}
