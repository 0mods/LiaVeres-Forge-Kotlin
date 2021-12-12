package com.algorithmlx.liaveres.item.armor

import com.algorithmlx.liaveres.LiaVeresKotlin.Constants.ModId
import com.algorithmlx.liaveres.api.LVArmorTiers
import com.algorithmlx.liaveres.setup.Registration.ItemReg
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.entity.Entity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.EquipmentSlotType
import net.minecraft.item.ArmorItem
import net.minecraft.item.ItemStack
import net.minecraft.potion.EffectInstance
import net.minecraft.potion.Effects
import net.minecraft.util.text.ITextComponent
import net.minecraft.util.text.TranslationTextComponent
import net.minecraft.world.World


class MatterCrystalArmor(p_i48534_2_: EquipmentSlotType, p_i48534_3_: Properties) : ArmorItem(LVArmorTiers.MATTER_CRYSTAL, p_i48534_2_, p_i48534_3_) {
    override fun onArmorTick(stack: ItemStack?, world: World?, player: PlayerEntity?) {
        super.onArmorTick(stack, world, player)
        if (!player!!.persistentData.contains("wearingFullMatterCrystalArmor")) player.persistentData
            .putBoolean("wearingFullMatterCrystalArmor", false)

        val head = player.getItemBySlot(EquipmentSlotType.HEAD)
        val chest = player.getItemBySlot(EquipmentSlotType.CHEST)
        val legs = player.getItemBySlot(EquipmentSlotType.LEGS)
        val feet = player.getItemBySlot(EquipmentSlotType.FEET)

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
            if (iswearingFullMatterCrystalArmor && (world.dimension().equals(World.OVERWORLD) || world.dimension().equals(World.NETHER) || world.dimension().equals(World.END))) {
                player.abilities.mayfly = true
            }
        }
        if (iswearingFullMatterCrystalArmor) {
            //bad effect remove
            if (player.getEffect(Effects.BLINDNESS) != null) {
                player.removeEffect(Effects.BLINDNESS)
            }
            if (player.getEffect(Effects.MOVEMENT_SLOWDOWN) != null) {
                player.removeEffect(Effects.MOVEMENT_SLOWDOWN)
            }
            if (player.getEffect(Effects.DIG_SLOWDOWN) != null) {
                player.removeEffect(Effects.DIG_SLOWDOWN)
            }
            if (player.getEffect(Effects.HARM) != null) {
                player.removeEffect(Effects.HARM)
            }
            if (player.getEffect(Effects.CONFUSION) != null) {
                player.removeEffect(Effects.CONFUSION)
            }
            if (player.getEffect(Effects.HUNGER) != null) {
                player.removeEffect(Effects.HUNGER)
            }
            if (player.getEffect(Effects.POISON) != null) {
                player.removeEffect(Effects.POISON)
            }
            if (player.getEffect(Effects.WITHER) != null) {
                player.removeEffect(Effects.WITHER)
            }
            if (player.getEffect(Effects.LEVITATION) != null) {
                player.removeEffect(Effects.LEVITATION)
            }
            if (player.getEffect(Effects.UNLUCK) != null) {
                player.removeEffect(Effects.UNLUCK)
            }
            if (player.getEffect(Effects.WEAKNESS) != null) {
                player.removeEffect(Effects.WEAKNESS)
            }
            //good effect add
            val nv = EffectInstance(Effects.NIGHT_VISION, 300, 0, false, false)
            player.addEffect(nv)
            val regen = EffectInstance(Effects.REGENERATION, 300, 2147483647, false, false)
            player.addEffect(regen)
            val underWater = EffectInstance(Effects.WATER_BREATHING, 300, 0, false, false)
            player.addEffect(underWater)
            val haste = EffectInstance(Effects.DIG_SPEED, 300, 20, false, false)
            player.addEffect(haste)
            val saturation = EffectInstance(Effects.SATURATION, 300, 50, false, false)
            player.addEffect(saturation)
            val strength = EffectInstance(Effects.DAMAGE_BOOST, 300, 20, false, false)
            player.addEffect(strength)
            val fr = EffectInstance(Effects.FIRE_RESISTANCE, 300, 2147483647, false, false)
            player.addEffect(fr)
            val luck = EffectInstance(Effects.LUCK, 300, 10, false, false)
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

    override fun getArmorTexture(stack: ItemStack?, entity: Entity?, slot: EquipmentSlotType?, type: String?): String {
        return if (slot == EquipmentSlotType.LEGS) {
            "$ModId:textures/armor/matter_crystal/2.png"
        }
        else {
            "$ModId:textures/armor/matter_crystal/1.png"
        }
    }
    override fun appendHoverText(p_77624_1_: ItemStack, p_77624_2_: World?, p_77624_3_: MutableList<ITextComponent>, p_77624_4_: ITooltipFlag) {
        p_77624_3_.add(TranslationTextComponent("msg.$ModId.matter_crystal_armor"))
        p_77624_3_.add(TranslationTextComponent("msg.$ModId.matter_crystal_msg"))
    }
}