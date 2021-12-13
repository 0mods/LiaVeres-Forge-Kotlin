package com.algorithmlx.liaveres.item.armor

import com.algorithmlx.liaveres.LiaVeresKotlin
import com.algorithmlx.liaveres.api.LVArmorTiers
import com.algorithmlx.liaveres.setup.Registration
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

class MatterArmor(p_i48534_2_: EquipmentSlot, p_i48534_3_: Properties) :
    ArmorItem(LVArmorTiers.MATTER, p_i48534_2_, p_i48534_3_) {
    override fun onArmorTick(stack: ItemStack?, world: Level?, player: Player?) {
        super.onArmorTick(stack, world, player)
        if (!player!!.persistentData.contains("wearingFullMatterArmor")) player.persistentData
            .putBoolean("wearingFullMatterArmor", false)

        val head = player.getItemBySlot(EquipmentSlot.HEAD)
        val chest = player.getItemBySlot(EquipmentSlot.CHEST)
        val legs = player.getItemBySlot(EquipmentSlot.LEGS)
        val feet = player.getItemBySlot(EquipmentSlot.FEET)

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

            val nv = MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0, false, false)
            player.addEffect(nv)
            val regen = MobEffectInstance(MobEffects.REGENERATION, 300, 2147483647, false, false)
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

    override fun getArmorTexture(stack: ItemStack?, entity: Entity?, slot: EquipmentSlot?, type: String?): String {
        return if (slot == EquipmentSlot.LEGS) {
            "${LiaVeresKotlin.Constants.ModId}:textures/armor/matter/2.png"
        }
        else {
            "${LiaVeresKotlin.Constants.ModId}:textures/armor/matter/1.png"
        }
    }
}