package com.github.wolfiewaffle.hardcoretorches.blocks;

import java.util.function.Function;

import javax.annotation.Nullable;

import com.github.wolfiewaffle.hardcoretorches.items.ItemTorchLit;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {
	public static Block torch_burnt;
	public static Block torch_lit = new BlockTorchLit("torch_lit");

    public static void createBlocks() {
    	registerBlock(torch_lit, ItemTorchLit::new);
    }

	/**
	 * Register a Block with a custom ItemBlock class.
	 *
	 * @param <BLOCK>     The Block type
	 * @param block       The Block instance
	 * @param itemFactory A function that creates the ItemBlock instance, or null if no ItemBlock should be created
	 * @return The Block instance
	 */
	protected static <BLOCK extends Block> BLOCK registerBlock(BLOCK block, @Nullable Function<BLOCK, ItemBlock> itemFactory) {
		GameRegistry.registerBlock(block);

		if (itemFactory != null) {
			final ItemBlock itemBlock = itemFactory.apply(block);

			GameRegistry.registerItem(itemBlock.setRegistryName(block.getRegistryName()));
		}

		return block;
	}
}
