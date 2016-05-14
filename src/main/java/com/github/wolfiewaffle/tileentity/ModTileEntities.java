package com.github.wolfiewaffle.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {
    public static void init() {
        GameRegistry.registerTileEntity(TileEntityTorch.class, "tileentity_torch_lit");
    }
}
