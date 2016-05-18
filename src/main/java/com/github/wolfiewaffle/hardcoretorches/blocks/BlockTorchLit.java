package com.github.wolfiewaffle.hardcoretorches.blocks;

import java.util.ArrayList;
import java.util.List;

import com.github.wolfiewaffle.hardcoretorches.HardcoreTorches;
import com.github.wolfiewaffle.hardcoretorches.tileentity.TileEntityTorch;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTorchLit extends BlockTorch implements ITileEntityProvider {
	public final static int MAX_FUEL = HardcoreTorches.configTorchFuel;

    public BlockTorchLit(String name) {
    	this();
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
    }

    public BlockTorchLit() {
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(0.0f);
        this.setResistance(0.0f);
        this.setLightLevel(1.0f);
        this.isBlockContainer = true;
    }

    // Create tile entity
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityTorch();
    }

	/**
	 * Required TE method. This cleans up the TE when the block is broken
	 * 
	 * @see net.minecraft.block.Block#breakBlock(net.minecraft.world.World,
	 *      net.minecraft.util.BlockPos, net.minecraft.block.state.IBlockState)
	 */
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        super.breakBlock(world, pos, state);
        world.removeTileEntity(pos);
    }

	/**
	 * Required TE method. Passes events to the TE
	 * 
	 * @see net.minecraft.block.Block#onBlockEventReceived(net.minecraft.world.World,
	 *      net.minecraft.util.BlockPos, net.minecraft.block.state.IBlockState,
	 *      int, int)
	 */
    @Override
    public boolean onBlockEventReceived(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam) {
        super.onBlockEventReceived(worldIn, pos, state, eventID, eventParam);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
    }

	/**
	 * Don't use the special TE rendering. This requires us to override this
	 * method and return 3
	 * 
	 * @see net.minecraft.block.Block#getRenderType()
	 */
    @Override
    public int getRenderType() {
    	return 3;
    }

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityTorch te = (TileEntityTorch) world.getTileEntity(pos);
		System.out.println(te);

		// Main logic, must make sure TE isn't null
		if (te != null) {
			if (HardcoreTorches.configDebug) System.out.printf("Right click. Fuel: %d\n", te.getFuelAmount());

			// Light held torches
			if (player.getHeldItem() == new ItemStack(ModBlocks.torch_burnt)) {
				System.out.println("Holding burnt torch");
			}
		}

		return super.onBlockActivated(world, pos, state, player, side, hitX, hitY, hitZ);
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		ArrayList<ItemStack> drop = new ArrayList<ItemStack>();

		// Torches should drop as burnt torches
		if (HardcoreTorches.configTorchDropMode == 0) {

			drop.add(new ItemStack(ModBlocks.torch_burnt, quantityDropped(state, fortune, RANDOM), 0));

		}
		// Torches should drop as lit or unlit torches with correct item damage
		else if (HardcoreTorches.configTorchDropMode == 1 || HardcoreTorches.configTorchDropMode == 2) {
			TileEntityTorch te = (TileEntityTorch) world.getTileEntity(pos);
			System.out.println(te);

			// Item damage goes from 0 to 1000, TE fuel value goes from 1000 to 0
			// itemDamage + fuel = MAX_FUEL
			int itemMeta = MAX_FUEL - te.getFuelAmount();

			// Torches should drop unlit
			if (HardcoreTorches.configTorchDropMode == 1) {
				drop.add(new ItemStack(ModBlocks.torch_lit, quantityDropped(state, fortune, RANDOM), itemMeta));
			}
			// Torches should drop lit
			else {
				drop.add(new ItemStack(ModBlocks.torch_lit, quantityDropped(state, fortune, RANDOM), itemMeta));
			}
		}

		return drop;
	}
}
