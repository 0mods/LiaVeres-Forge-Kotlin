package com.algorithmlx.liaveres.item.armor

import com.algorithmlx.liaveres.LiaVeresKotlin.Constants.ModId
import com.algorithmlx.liaveres.api.LVArmorTiers
import com.algorithmlx.liaveres.setup.Registration.ItemReg
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.TranslatableComponent
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.Level


class MatterCrystalArmor(p_i48534_2_: EquipmentSlot, p_i48534_3_: Properties) : ArmorItem(LVArmorTiers.MATTER_CRYSTAL, p_i48534_2_, p_i48534_3_) {
    override fun onArmorTick(stack: ItemStack?, world: Level?, player: Player?) {
        super.onArmorTick(stack, world, player)
        if (!player!!.persistentData.contains("wearingFullMatterCrystalArmor")) player.persistentData
            .putBoolean("wearingFullMatterCrystalArmor", false)

        val head = player.getItemBySlot(EquipmentSlot.HEAD)
        val chest = player.getItemBySlot(EquipmentSlot.CHEST)
        val legs = player.getItemBySlot(EquipmentSlot.LEGS)
        val feet = player.getItemBySlot(EquipmentSlot.FEET)

        if (!player.persistentData.contains("wearingFullMatterCrystalArmor")) player
            .persistentData.putBoolean("wearingFullMatterCrystalArmor", false)
        val iswearingFullMatterCrystalArmor =
            head != null && head.item === ItemReg.MATTER_CRYSTAL_HELMET
                    && chest != null && chest.item === ItemReg.MATTER_CRYSTAL_CHESTPLATE
                    && legs != null && legs.item === ItemReg.MATTER_CRYSTAL_LEGS
                    && feet != null && feet.item === ItemReg.MATTER_CRYSTAL_BOOTS

        val wasWearingMatterCrystalArmorLastTick = player.persistentData
            .getBoolean("wearingFullMatterCrystalArmor")

        if (!iswearingFullMatterCrystalArmor && wasWearingMatterCrystalArmorLastTick && !player.isCreative) {
            player.abilities.flying = false
            player.abilities.mayfly = false
        } else if (world != null) {
            if (iswearingFullMatterCrystalArmor && (world.dimension().equals(Level.OVERWORLD) || world.dimension().equals(Level.NETHER) || world.dimension().equals(Level.END))) {
                player.abilities.mayfly = true
            }
        }
        if (iswearingFullMatterCrystalArmor) {
            //bad effect remove
            if (player.getEffect(MobEffects.BLINDNESS) != null) {
                player.removeEffect(MobEffects.BLINDNESS)
            }
            if (player.getEffect(MobEffects.MOVEMENT_SLOWDOWN) != null) {
                player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN)
            }
            if (player.getEffect(MobEffects.DIG_SLOWDOWN) != null) {
                player.removeEffect(MobEffects.DIG_SLOWDOWN)
            }
            if (player.getEffect(MobEffects.HARM) != null) {
                player.removeEffect(MobEffects.HARM)
            }
            if (player.getEffect(MobEffects.CONFUSION) != null) {
                player.removeEffect(MobEffects.CONFUSION)
            }
            if (player.getEffect(MobEffects.HUNGER) != null) {
                player.removeEffect(MobEffects.HUNGER)
            }
            if (player.getEffect(MobEffects.POISON) != null) {
                player.removeEffect(MobEffects.POISON)
            }
            if (player.getEffect(MobEffects.WITHER) != null) {
                player.removeEffect(MobEffects.WITHER)
            }
            if (player.getEffect(MobEffects.LEVITATION) != null) {
                player.removeEffect(MobEffects.LEVITATION)
            }
            if (player.getEffect(MobEffects.UNLUCK) != null) {
                player.removeEffect(MobEffects.UNLUCK)
            }
            if (player.getEffect(MobEffects.WEAKNESS) != null) {
                player.removeEffect(MobEffects.WEAKNESS)
            }
            //good effect add
            val nv = MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0, false, false)
            player.addEffect(nv)
            val regen = MobEffectInstance(MobEffects.REGENERATION, 300, 2147483647, false, false)
            player.addEffect(regen)
            val underWater = MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0, false, false)
            player.addEffect(underWater)
            val haste = MobEffectInstance(MobEffects.DIG_SPEED, 300, 20, false, false)
            player.addEffect(haste)
            val saturation = MobEffectInstance(MobEffects.SATURATION, 300, 50, false, false)
            player.addEffect(saturation)
            val strength = MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 20, false, false)
            player.addEffect(strength)
            val fr = MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 2147483647, false, false)
            player.addEffect(fr)
            val luck = MobEffectInstance(MobEffects.LUCK, 300, 10, false, false)
            player.addEffect(luck)
        }
        player.persistentData.putBoolean("wearingFullMatterCrystalArmor", iswearingFullMatterCrystalArmor)
    }

    override fun hasContainerItem(stack: ItemStack?): Boolean {
        return true
    }

    override fun getContainerItem(itemStack: ItemStack?): ItemStack {
        return itemStack!!.copy()
    }

    override fun getArmorTexture(stack: ItemStack?, entity: Entity?, slot: EquipmentSlot?, type: String?): String {
        return if (slot == EquipmentSlot.LEGS) {
            "$ModId:textures/armor/matter_crystal/2.png"
        }
        else {
            "$ModId:textures/armor/matter_crystal/1.png"
        }
    }
    override fun appendHoverText(p_41421_: ItemStack, p_41422_: Level?, p_41423_: MutableList<Component>, p_41424_: TooltipFlag) {
        p_41423_.add(TranslatableComponent("msg.$ModId.matter_crystal_armor"))
        p_41423_.add(TranslatableComponent("msg.$ModId.matter_crystal_msg"))
    }
}