package com.algorithmlx.liaveres.item

import com.algorithmlx.liaveres.LiaVeresKotlin.Constants.ModId
import com.algorithmlx.liaveres.setup.Tabs.*
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.item.Food
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Rarity
import net.minecraft.util.text.ITextComponent
import net.minecraft.util.text.TranslationTextComponent
import net.minecraft.world.World

class EnchantedApple : Item(Properties().tab(LVTab).food(Food.Builder().nutrition(10).saturationMod(10f).build()).rarity(Rarity.EPIC)) {
    override fun isFoil(p_77636_1_: ItemStack): Boolean {
        return true
    }

    override fun appendHoverText(p_77624_1_: ItemStack, p_77624_2_: World?, p_77624_3_: MutableList<ITextComponent>, p_77624_4_: ITooltipFlag) {
        p_77624_3_.add(TranslationTextComponent("msg.$ModId.enchanted_apple"))
    }
}