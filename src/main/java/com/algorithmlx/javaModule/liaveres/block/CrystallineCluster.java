package com.algorithmlx.javaModule.liaveres.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class CrystallineCluster extends BushBlock {
    public CrystallineCluster() {
        super(Properties.of(Material.METAL).requiresCorrectToolForDrops().noOcclusion().lightLevel((p_235435_0_) -> 10).strength(5f, -1f));
    }

    @Override
    protected boolean mayPlaceOn(BlockState p_200014_1_, BlockGetter p_200014_2_, BlockPos p_200014_3_) {
        BlockState state = p_200014_2_.getBlockState(p_200014_3_);
        BlockState state1 = p_200014_2_.getBlockState(p_200014_3_.above());
        return (state.getBlock() == Blocks.STONE || p_200014_1_.getMaterial() == Material.STONE) && state1.getBlock() == Blocks.AIR;
    }
}
