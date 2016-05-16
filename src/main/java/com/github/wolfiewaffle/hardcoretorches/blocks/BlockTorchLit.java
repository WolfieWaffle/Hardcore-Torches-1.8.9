package com.github.wolfiewaffle.hardcoretorches.blocks;

import com.github.wolfiewaffle.hardcoretorches.tileentity.TileEntityTorch;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public final class BlockTorchLit extends BlockTorch implements ITileEntityProvider {
	// Instance variables
	public final static int MAX_FUEL = 1000; // Max duration in ticks

	// Constructor
    public BlockTorchLit(String unlocalizedName) {
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(0.0f);
        this.setResistance(0.0f);
        this.setLightLevel(0.0f);
		this.setRegistryName("torch_lit");
    }

    // Create tile entity
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityTorch();
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

    /**
     * Don't use the special TE rendering. This requires us to override this method and return 3
     * @see net.minecraft.block.Block#getRenderType()
     */
    @Override
    public int getRenderType() {
    	return 3;
    }
}
