package com.github.wolfiewaffle.hardcoretorches.blocks;

import com.github.wolfiewaffle.hardcoretorches.tileentity.TileEntityTorch;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTorchCokeLit extends BlockTorchLit implements ITileEntityProvider {

	public final static int MAX_FUEL = 1000;

    public BlockTorchCokeLit(String name) {
    	super(name);
    }
 
    // Create tile entity
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityTorch();
    }
}
