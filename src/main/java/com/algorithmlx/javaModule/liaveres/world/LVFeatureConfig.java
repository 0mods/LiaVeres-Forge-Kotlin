package com.algorithmlx.javaModule.liaveres.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class LVFeatureConfig implements FeatureConfiguration {
    public static final Codec<LVFeatureConfig> CODEC = RecordCodecBuilder.create((p_236568_0_)
            -> p_236568_0_.group(RuleTest.CODEC.fieldOf("target").forGetter((p_236570_0_)
            -> p_236570_0_.target), BlockState.CODEC.fieldOf("state").forGetter((p_236569_0_)
            -> p_236569_0_.state), Codec.intRange(0, 64).fieldOf("size").forGetter((p_236567_0_)
            -> p_236567_0_.size)).apply(p_236568_0_, LVFeatureConfig::new)
    );
    public final RuleTest target;
    public final int size;
    public final BlockState state;

    public LVFeatureConfig(RuleTest test, BlockState state, int size) {
        this.size = size;
        this.state = state;
        this.target = test;
    }

    public static final class Fill {
        public static final RuleTest END_STONE = new BlockMatchTest(Blocks.END_STONE);
    }
}
