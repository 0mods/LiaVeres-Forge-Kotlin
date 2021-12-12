package com.algorithmlx.liaveres.setup

import com.algorithmlx.javaModule.liaveres.block.CrystallineCluster
import com.algorithmlx.liaveres.block.*
import com.algorithmlx.liaveres.item.*
import com.algorithmlx.liaveres.setup.Tabs.*
import com.algorithmlx.liaveres.item.armor.*
import net.minecraft.block.Block
import net.minecraft.inventory.EquipmentSlotType
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.eventbus.api.SubscribeEvent

class Registration {
    object ItemReg  {
        val MATTER_CRYSTAL = MatterCrystal().setRegistryName("matter_crystal")
        val MATTER_CRYSTAL_AXE = MatterCrystalAxe().setRegistryName("matter_crystal_axe")
        val MATTER_CRYSTAL_PICKAXE = MatterCrystalPickaxe().setRegistryName("matter_crystal_pickaxe")
        val CRYSTALLINE = Crystalline().setRegistryName("crystalline")
        val MATTER = Matter().setRegistryName("matter")
        val MATTER_CRYSTAL_SWORD = MatterCrystalSword().setRegistryName("matter_crystal_sword")
        val MATTER_CRYSTAL_SHOVEL = MatterCrystalShovel().setRegistryName("matter_crystal_shovel")
        val MATTER_CRYSTAL_HOE = MatterCrystalHoe().setRegistryName("matter_crystal_hoe")
        val ENCHANTED_APPLE = EnchantedApple().setRegistryName("enchanted_apple")
        val EFFECT_CATALYST = EffectCatalyst().setRegistryName("effect_catalyst")

        val MATTER_CRYSTAL_HELMET = MatterCrystalArmor(EquipmentSlotType.HEAD, Item.Properties().tab(LVTab).fireResistant()).setRegistryName("matter_crystal_helmet")
        val MATTER_CRYSTAL_CHESTPLATE = MatterCrystalArmor(EquipmentSlotType.CHEST, Item.Properties().tab(LVTab).fireResistant()).setRegistryName("matter_crystal_chestplate")
        val MATTER_CRYSTAL_LEGS = MatterCrystalArmor(EquipmentSlotType.LEGS, Item.Properties().tab(LVTab).fireResistant()).setRegistryName("matter_crystal_leggings")
        val MATTER_CRYSTAL_BOOTS = MatterCrystalArmor(EquipmentSlotType.FEET, Item.Properties().tab(LVTab).fireResistant()).setRegistryName("matter_crystal_boots")
        val MATTER_HELMET = MatterArmor(EquipmentSlotType.HEAD, Item.Properties().tab(LVTab).fireResistant()).setRegistryName("matter_helmet")
        val MATTER_CHESTPLATE = MatterArmor(EquipmentSlotType.CHEST, Item.Properties().tab(LVTab).fireResistant()).setRegistryName("matter_chestplate")
        val MATTER_LEGS = MatterArmor(EquipmentSlotType.LEGS, Item.Properties().tab(LVTab).fireResistant()).setRegistryName("matter_leggings")
        val MATTER_BOOTS = MatterArmor(EquipmentSlotType.FEET, Item.Properties().tab(LVTab).fireResistant()).setRegistryName("matter_boots")

        val MATTER_CRYSTAL_BLOCK_ITEM = BlockItem(BlockReg.MATTER_CRYSTAL_BLOCK, Item.Properties().tab(LVTab).fireResistant()).setRegistryName("matter_crystal_block")
        val MATTER_BLOCK_ITEM = BlockItem(BlockReg.MATTER_BLOCK, Item.Properties().tab(LVTab)).setRegistryName("matter_block")
        val CRYSTALLINE_CLUSTER_ITEM = BlockItem(BlockReg.CRYSTALLINE_CLUSTER, Item.Properties().tab(LVTab)).setRegistryName("crystalline_cluster")

        val ListItem = arrayOf(
            MATTER_CRYSTAL,
            MATTER_CRYSTAL_BLOCK_ITEM,
            MATTER_CRYSTAL_HELMET,
            MATTER_CRYSTAL_CHESTPLATE,
            MATTER_CRYSTAL_LEGS,
            MATTER_CRYSTAL_BOOTS,
            MATTER_CRYSTAL_AXE,
            MATTER_CRYSTAL_PICKAXE,
            CRYSTALLINE,
            MATTER,
            MATTER_CRYSTAL_SHOVEL,
            MATTER_CRYSTAL_SWORD,
            MATTER_CRYSTAL_HOE,
            ENCHANTED_APPLE,
            MATTER_HELMET,
            MATTER_CHESTPLATE,
            MATTER_LEGS,
            MATTER_BOOTS,
            EFFECT_CATALYST,
            MATTER_BLOCK_ITEM,
            CRYSTALLINE_CLUSTER_ITEM
        )
    }

    object BlockReg {
        val MATTER_CRYSTAL_BLOCK = MatterCrystalBlock().setRegistryName("matter_crystal_block")
        val MATTER_BLOCK = MatterBlock().setRegistryName("matter_block")
        val CRYSTALLINE_CLUSTER = CrystallineCluster().setRegistryName("crystalline_cluster")
        val ListBlock = arrayOf<Block>(
            MATTER_CRYSTAL_BLOCK,
            MATTER_BLOCK,
            CRYSTALLINE_CLUSTER
         )
    }

    class ItemRegister {
        @SubscribeEvent
        fun register(event: RegistryEvent.Register<Item>) {
            val reg = event.registry
            reg.registerAll(*ItemReg.ListItem)
        }
    }
    class BlockRegister {
        @SubscribeEvent
        fun register(event: RegistryEvent.Register<Block>) {
            val reg = event.registry
            reg.registerAll(*BlockReg.ListBlock)
        }
    }
}