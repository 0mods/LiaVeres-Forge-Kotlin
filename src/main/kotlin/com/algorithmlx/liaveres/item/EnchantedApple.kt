package com.algorithmlx.liaveres.item

import com.algorithmlx.liaveres.LiaVeresKotlin.Constants.ModId
import com.algorithmlx.liaveres.setup.Tabs.*
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.TranslatableComponent
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Rarity
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.Level

class EnchantedApple : Item(Properties().tab(LVTab).food(FoodProperties.Builder().nutrition(10).saturationMod(10f).build()).rarity(Rarity.EPIC)) {
    override fun isFoil(p_77636_1_: ItemStack): Boolean {
        return true
    }

    override fun appendHoverText(p_77624_1_: ItemStack, p_77624_2_: Level?, p_77624_3_: MutableList<Component>, p_77624_4_: TooltipFlag) {
        p_77624_3_.add(TranslatableComponent("msg.$ModId.enchanted_apple"))
    }
}