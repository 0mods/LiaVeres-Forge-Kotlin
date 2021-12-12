package com.algorithmlx.javaModule.liaveres.world.gen;

import com.algorithmlx.javaModule.liaveres.RegistryOther;
import com.algorithmlx.javaModule.liaveres.world.LVFeatureConfig;
import com.algorithmlx.liaveres.LiaVeresKotlin;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class OreGen {
    public static ConfiguredFeature<?,?> CRYSTALLINE;
    public static ConfiguredFeature<?,?> CRYSTALLINE_NETHER;
    public static ConfiguredFeature<?,?> CRYSTALLINE_END;

    public static void ores() {
        CRYSTALLINE = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryOther.CRYSTALLINE_CLUSTER.get().defaultBlockState(), 1)).range(50).squared().count(1);
        CRYSTALLINE_NETHER = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, RegistryOther.CRYSTALLINE_CLUSTER.get().defaultBlockState(), 4)).range(256).squared().count(1);
        CRYSTALLINE_END = Feature.ORE.configured(new OreFeatureConfig(LVFeatureConfig.Fill.END_STONE, RegistryOther.CRYSTALLINE_CLUSTER.get().defaultBlockState(), 4)).range(256).squared().count(1);

        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(LiaVeresKotlin.Constants.ModId, "crystalline_cluster"), CRYSTALLINE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(LiaVeresKotlin.Constants.ModId, "crystalline_cluster"), CRYSTALLINE_END);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(LiaVeresKotlin.Constants.ModId, "crystalline_cluster"), CRYSTALLINE_NETHER);
    }

    @SubscribeEvent
    public static void biomeModification(final BiomeLoadingEvent event) {
        ores();
        event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> CRYSTALLINE);
        event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> CRYSTALLINE_NETHER);
        event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> CRYSTALLINE_END);
    }
}
