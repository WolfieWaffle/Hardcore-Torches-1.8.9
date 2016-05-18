package com.github.wolfiewaffle.hardcoretorches.blocks;

import com.github.wolfiewaffle.hardcoretorches.items.ItemTorchCokeLit;
import com.github.wolfiewaffle.hardcoretorches.items.ItemTorchLit;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {
	public static Block torch_burnt;
	public static Block torch_lit;
	public static Block torch_coke_lit;
	public static Block test_block;

    public static void createBlocks() {
    	GameRegistry.registerBlock(torch_lit = new BlockTorchLit("torch_lit"), ItemTorchLit.class);
    	GameRegistry.registerBlock(torch_coke_lit = new BlockTorchCokeLit("torch_coke_lit"), ItemTorchCokeLit.class);
    	GameRegistry.registerBlock(torch_burnt = new BlockTorchBurnt("torch_burnt"));
    	GameRegistry.registerBlock(test_block = new BlockTest("test_block"));
    }

	/**
	 * Register a Block with the default ItemBlock class.
	 *
	 * @param block   The Block instance
	 * @param <BLOCK> The Block type
	 * @return The Block instance
	 */
	//protected static <BLOCK extends Block> BLOCK registerBlock(BLOCK block) {
		//return registerBlock(block, ItemBlock::new);
	//}

	/**
	 * Register a Block with a custom ItemBlock class.
	 *
	 * @param <BLOCK>     The Block type
	 * @param block       The Block instance
	 * @param itemFactory A function that creates the ItemBlock instance, or null if no ItemBlock should be created
	 * @return The Block instance
	 */
	/*protected static <BLOCK extends Block> BLOCK registerBlock(BLOCK block, ) {
		GameRegistry.registerBlock(block, );

		return block;
	}*/
}
