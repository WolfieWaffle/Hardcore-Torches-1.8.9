package com.github.wolfiewaffle.hardcoretorches.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemTorchLit extends ItemBlock {
	/*
	 *  Constructor must be passed a valid Block for registration,
	 *  this is the ItemBlock version of that Block
	 */
	public ItemTorchLit(Block block) {
		super(block);
		this.setRegistryName("torch_lit");
	}

	
}
