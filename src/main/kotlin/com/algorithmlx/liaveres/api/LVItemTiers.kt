package com.algorithmlx.liaveres.api

import com.algorithmlx.liaveres.setup.Registration
import net.minecraft.item.IItemTier
import net.minecraft.item.crafting.Ingredient

object LVItemTiers {
    val MATTER_CRYSTAL = ToolTierCore(
        2147483647,
        -1,
        340282356779733661637539395458142568447F,
        340282356779733661637539395458142568447F,
        2147483647,
        Ingredient.of(
            Registration.ItemReg.MATTER_CRYSTAL
        )
    )

    class ToolTierCore(
        private val harvestLevel: Int,
        private val maxUses: Int,
        private val efficiency: Float,
        private val attackDamage: Float,
        private val enchantability: Int,
        private val repairMaterial: Ingredient
    ) : IItemTier {
        override fun getLevel() = harvestLevel
        override fun getUses() = maxUses
        override fun getSpeed() = efficiency
        override fun getAttackDamageBonus() = attackDamage
        override fun getEnchantmentValue() = enchantability
        override fun getRepairIngredient() = repairMaterial
    }
}