package com.github.wolfiewaffle.hardcoretorches.items;

import com.github.wolfiewaffle.hardcoretorches.HardcoreTorches;
import com.github.wolfiewaffle.hardcoretorches.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemTorchLit extends ItemBlock {
	public ItemTorchLit(Block block) {
		super(block);
		this.hasSubtypes = true;
		this.setMaxDamage(HardcoreTorches.configTorchFuel);
		this.setRegistryName(ModBlocks.torch_lit.getRegistryName());
		this.setMaxStackSize(1);
	}
}
