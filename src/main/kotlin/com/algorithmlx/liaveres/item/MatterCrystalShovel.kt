package com.algorithmlx.liaveres.item

import com.algorithmlx.liaveres.LiaVeresKotlin
import com.algorithmlx.liaveres.api.LVItemTiers
import com.algorithmlx.liaveres.setup.Tabs.*
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.TranslatableComponent
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.ShovelItem
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.Level

class MatterCrystalShovel :
    ShovelItem(LVItemTiers.MATTER_CRYSTAL, 340282356779733661637539395458142568447F, 340282356779733661637539395458142568447F, Properties().fireResistant().tab(LVTab)) {
    override fun hasContainerItem(stack: ItemStack?): Boolean {
        return true
    }

    override fun getContainerItem(itemStack: ItemStack?): ItemStack {
        return itemStack!!.copy()
    }
    override fun appendHoverText(p_41421_: ItemStack, p_41422_: Level?, p_41423_: MutableList<Component>, p_41424_: TooltipFlag) {
        p_41423_.add(TranslatableComponent("msg.${LiaVeresKotlin.Constants.ModId}.matter_crystal_msg"))
    }
}