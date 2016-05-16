package com.github.wolfiewaffle.hardcoretorches.items;

import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchLit;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemTorchLit extends ItemBlock {
	// Constructor
	public ItemTorchLit(Block block) {
		super(block);
		this.hasSubtypes = true;
		this.setMaxDamage(BlockTorchLit.MAX_FUEL);
	}
}
