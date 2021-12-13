package com.algorithmlx.liaveres.api

import com.algorithmlx.liaveres.setup.Registration
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Tier
import net.minecraft.world.item.crafting.Ingredient

object LVItemTiers {
    val MATTER_CRYSTAL = ToolTierCore(
        2147483647,
        -1,
        340282356779733661637539395458142568447F,
        340282356779733661637539395458142568447F,
        2147483647,
        Ingredient.of(
            ItemStack(Registration.ItemReg.MATTER_CRYSTAL)
        )
    )

    class ToolTierCore(
        private val harvestLevel: Int,
        private val maxUses: Int,
        private val efficiency: Float,
        private val attackDamage: Float,
        private val enchantability: Int,
        private val repairMaterial: Ingredient
    ) : Tier {
        override fun getLevel() = harvestLevel
        override fun getUses() = maxUses
        override fun getSpeed() = efficiency
        override fun getAttackDamageBonus() = attackDamage
        override fun getEnchantmentValue() = enchantability
        override fun getRepairIngredient() = repairMaterial
    }
}