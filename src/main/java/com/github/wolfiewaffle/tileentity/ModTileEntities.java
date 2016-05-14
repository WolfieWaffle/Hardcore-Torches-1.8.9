package com.github.wolfiewaffle.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {
    public static void init() {
        GameRegistry.registerTileEntity(TileEntityTorchLitBase.class, "tileentity_torch_lit");
    }
}
