package com.github.wolfiewaffle.hardcoretorches.blocks;

import net.minecraft.block.BlockTorch;
import net.minecraft.creativetab.CreativeTabs;

class BlockTorchBasic extends BlockTorch {
    public BlockTorchBasic(String unlocalizedName) {
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(0.0f);
        this.setResistance(0.0f);
        this.setLightLevel(3.0f);
    }
}
