package com.algorithmlx.liaveres.setup

import com.algorithmlx.liaveres.LiaVeresKotlin
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack

class Tabs {
    object LVTab: CreativeModeTab(LiaVeresKotlin.Constants.ModId + LiaVeresKotlin.Constants.TabName) {
        override fun makeIcon(): ItemStack {
            return ItemStack(Registration.ItemReg.MATTER_CRYSTAL)
        }
    }
}