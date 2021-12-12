package com.algorithmlx.javaModule.liaveres.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CrystallineCluster extends Block {
    public CrystallineCluster() {
        super(AbstractBlock.Properties.of(Material.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(3).requiresCorrectToolForDrops().noOcclusion().lightLevel(s -> 1));
    }
}
