package com.algorithmlx.javaModule.liaveres;

import com.algorithmlx.javaModule.liaveres.block.CrystallineCluster;
import com.algorithmlx.liaveres.setup.Tabs;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.algorithmlx.liaveres.LiaVeresKotlin.Constants;

public class RegistryOther {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.ModId);
    public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.ModId);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCK.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<CrystallineCluster> CRYSTALLINE_CLUSTER = BLOCK.register("crystalline_cluster", CrystallineCluster::new);
    public static final RegistryObject<Item> CRYSTALLINE_CLUSTER_ITEM = ITEMS.register("crystalline_cluster",
            ()-> new BlockItem(CRYSTALLINE_CLUSTER.get(), new Item.Properties().tab(Tabs.LVTab.INSTANCE)));
}
