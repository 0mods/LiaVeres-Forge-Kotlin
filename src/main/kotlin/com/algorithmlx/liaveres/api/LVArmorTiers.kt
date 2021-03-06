package com.algorithmlx.liaveres.api

import com.algorithmlx.liaveres.setup.Registration
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.Ingredient

object LVArmorTiers {
    val MATTER_CRYSTAL = ArmorTierCore("matter_crystal", -1, arrayOf(2147483647, 2147483647, 2147483647, 2147483647), 2147483647, SoundEvents.ARMOR_EQUIP_NETHERITE, 340282356779733661637539395458142568447F, 340282356779733661637539395458142568447F, Ingredient.of(
            ItemStack(Registration.ItemReg.MATTER_CRYSTAL)
        )
    )
    val MATTER = ArmorTierCore("matter", 6000, arrayOf(5000, 15000, 20000, 10000), 6, SoundEvents.ARMOR_EQUIP_DIAMOND, 20F, 0.5F, Ingredient.of(
            ItemStack(Registration.ItemReg.MATTER)
        )
    )

    class ArmorTierCore(
        private val name: String,
        private val maxDamageFactor: Int,
        private val damageReductionAmountArray: Array<Int>,
        private val enchantability: Int,
        private val soundEvent: SoundEvent,
        private val toughness: Float,
        private val knockbackResistance: Float,
        private val repairMaterial: Ingredient
    ) : ArmorMaterial {
        override fun getName() = name
        override fun getDurabilityForSlot(slot: EquipmentSlot) = MAX_DAMAGE_ARRAY[slot.index] * maxDamageFactor
        override fun getDefenseForSlot(slot: EquipmentSlot) = damageReductionAmountArray[slot.index]
        override fun getEnchantmentValue() = enchantability
        override fun getEquipSound() = soundEvent
        override fun getToughness() = toughness
        override fun getKnockbackResistance() = knockbackResistance
        override fun getRepairIngredient() = repairMaterial

        companion object {
            private val MAX_DAMAGE_ARRAY = intArrayOf(13, 15, 16, 11)
        }
    }
}