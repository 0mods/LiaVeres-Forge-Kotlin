package com.algorithmlx.liaveres.item

import com.algorithmlx.liaveres.LiaVeresKotlin.Constants.ModId
import com.algorithmlx.liaveres.setup.Tabs.*
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.text.ITextComponent
import net.minecraft.util.text.TranslationTextComponent
import net.minecraft.world.World

class EffectCatalyst : Item(Properties().tab(LVTab).fireResistant()) {
    override fun appendHoverText(
        p_77624_1_: ItemStack,
        p_77624_2_: World?,
        p_77624_3_: MutableList<ITextComponent>,
        p_77624_4_: ITooltipFlag
    ) {
        p_77624_3_.add(TranslationTextComponent("msg.$ModId.effect_catalyst"))
    }
}