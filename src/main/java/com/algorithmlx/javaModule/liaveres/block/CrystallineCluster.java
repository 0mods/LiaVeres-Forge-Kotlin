package com.algorithmlx.javaModule.liaveres.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class CrystallineCluster extends BushBlock {
    public CrystallineCluster() {
        super(AbstractBlock.Properties.of(Material.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(3).requiresCorrectToolForDrops().noOcclusion().lightLevel((p_235435_0_) -> 10).strength(5f, -1f));
    }

    @Override
    protected boolean mayPlaceOn(BlockState p_200014_1_, IBlockReader p_200014_2_, BlockPos p_200014_3_) {
        BlockState state = p_200014_2_.getBlockState(p_200014_3_);
        BlockState state1 = p_200014_2_.getBlockState(p_200014_3_.above());
        return (state.getBlock() == Blocks.STONE || p_200014_1_.getMaterial() == Material.STONE) && state1.getBlock() == Blocks.AIR;
    }
}
