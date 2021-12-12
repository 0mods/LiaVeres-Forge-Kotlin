package com.algorithmlx.liaveres.item.armor

import com.algorithmlx.liaveres.LiaVeresKotlin
import com.algorithmlx.liaveres.api.LVArmorTiers
import com.algorithmlx.liaveres.setup.Registration
import net.minecraft.entity.Entity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.EquipmentSlotType
import net.minecraft.item.ArmorItem
import net.minecraft.item.ItemStack
import net.minecraft.potion.EffectInstance
import net.minecraft.potion.Effects
import net.minecraft.world.World

class MatterArmor(p_i48534_2_: EquipmentSlotType, p_i48534_3_: Properties) :
    ArmorItem(LVArmorTiers.MATTER, p_i48534_2_, p_i48534_3_) {
    override fun onArmorTick(stack: ItemStack?, world: World?, player: PlayerEntity?) {
        super.onArmorTick(stack, world, player)
        if (!player!!.persistentData.contains("wearingFullMatterArmor")) player.persistentData
            .putBoolean("wearingFullMatterArmor", false)

        val head = player.getItemBySlot(EquipmentSlotType.HEAD)
        val chest = player.getItemBySlot(EquipmentSlotType.CHEST)
        val legs = player.getItemBySlot(EquipmentSlotType.LEGS)
        val feet = player.getItemBySlot(EquipmentSlotType.FEET)

        if (!player.persistentData.contains("wearingFullMatterArmor")) player
            .persistentData.putBoolean("wearingFullMatterArmor", false)
        val iswearingFullMatterArmor =
            head != null && head.item === Registration.ItemReg.MATTER_HELMET
                    && chest != null && chest.item === Registration.ItemReg.MATTER_CHESTPLATE
                    && legs != null && legs.item === Registration.ItemReg.MATTER_LEGS
                    && feet != null && feet.item === Registration.ItemReg.MATTER_BOOTS

        val wasWearingMatterArmorLastTick = player.persistentData
            .getBoolean("wearingFullMatterArmor")
        if (iswearingFullMatterArmor) {

            val nv = EffectInstance(Effects.NIGHT_VISION, 300, 0, false, false)
            player.addEffect(nv)
            val regen = EffectInstance(Effects.REGENERATION, 300, 2147483647, false, false)
            player.addEffect(regen)
        }
        player.persistentData.putBoolean("wearingFullMatterArmor", iswearingFullMatterArmor)
    }
    override fun hasContainerItem(stack: ItemStack?): Boolean {
        return true
    }

    override fun getContainerItem(itemStack: ItemStack?): ItemStack {
        return itemStack!!.copy()
    }

    override fun getArmorTexture(stack: ItemStack?, entity: Entity?, slot: EquipmentSlotType?, type: String?): String {
        return if (slot == EquipmentSlotType.LEGS) {
            "${LiaVeresKotlin.Constants.ModId}:textures/armor/matter/2.png"
        }
        else {
            "${LiaVeresKotlin.Constants.ModId}:textures/armor/matter/1.png"
        }
    }
}