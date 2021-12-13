package com.algorithmlx.javaModule.liaveres.world.gen;

import com.algorithmlx.javaModule.liaveres.RegistryOther;
import com.algorithmlx.javaModule.liaveres.world.LVFeatureConfig;
import com.algorithmlx.liaveres.LiaVeresKotlin;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class OreGen {
    public static ConfiguredFeature<?,?> CRYSTALLINE;
    public static ConfiguredFeature<?,?> CRYSTALLINE_NETHER;
    public static ConfiguredFeature<?,?> CRYSTALLINE_END;

    public static void ores() {
        CRYSTALLINE = Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE, RegistryOther.CRYSTALLINE_CLUSTER.get().defaultBlockState(), 1)).rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(50)).squared().count(1);
        CRYSTALLINE_NETHER = Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NETHERRACK, RegistryOther.CRYSTALLINE_CLUSTER.get().defaultBlockState(), 4)).rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(256)).squared().count(1);
        CRYSTALLINE_END = Feature.ORE.configured(new OreConfiguration(LVFeatureConfig.Fill.END_STONE, RegistryOther.CRYSTALLINE_CLUSTER.get().defaultBlockState(), 4)).rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(256)).squared().count(1);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(LiaVeresKotlin.Constants.ModId, "crystalline_cluster"), CRYSTALLINE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(LiaVeresKotlin.Constants.ModId, "crystalline_cluster"), CRYSTALLINE_END);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(LiaVeresKotlin.Constants.ModId, "crystalline_cluster"), CRYSTALLINE_NETHER);
    }

    @SubscribeEvent
    public static void biomeModification(final BiomeLoadingEvent event) {
        ores();
        event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> CRYSTALLINE);
        event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> CRYSTALLINE_NETHER);
        event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> CRYSTALLINE_END);
    }
}
