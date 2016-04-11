package com.github.wolfiewaffle.hardcoretorches.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

	public static Item animal_fat;

    public static void createItems() {
    	GameRegistry.registerItem(animal_fat = new BasicItem("animal_fat"), "animal_fat");
    }
}
