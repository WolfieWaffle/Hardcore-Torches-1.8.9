package com.github.wolfiewaffle.hardcoretorches.blocks;

import java.util.Random;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

final class BlockTorchLit extends BlockTorch implements ITileEntityProvider {
    public BlockTorchLit(String unlocalizedName, Material material, float hardness, float resistance) {
        super();
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.isBlockContainer = true;
    }

    // Create tile entity
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new ModTileEntity();
    }

    /**
     * Required TE method. This cleans up the TE when the block is broken
     * @see net.minecraft.block.Block#breakBlock(net.minecraft.world.World, net.minecraft.util.BlockPos, net.minecraft.block.state.IBlockState)
     */
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        super.breakBlock(world, pos, state);
        world.removeTileEntity(pos);
    }

    /**
     * Required TE method. Passes events to the TE
     * @see net.minecraft.block.Block#onBlockEventReceived(net.minecraft.world.World, net.minecraft.util.BlockPos, net.minecraft.block.state.IBlockState, int, int)
     */
    @Override
    public boolean onBlockEventReceived(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam) {
        super.onBlockEventReceived(worldIn, pos, state, eventID, eventParam);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
    }

    @Override
    public int getRenderType() {
    	return 3;
    }
}
