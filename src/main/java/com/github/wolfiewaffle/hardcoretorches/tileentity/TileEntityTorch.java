package com.github.wolfiewaffle.hardcoretorches.tileentity;

import net.minecraft.tileentity.TileEntity;

public class TileEntityTorch extends TileEntity implements net.minecraft.util.ITickable {
	@Override
	public void update() {
		System.out.println("TORCH");
	}
}
