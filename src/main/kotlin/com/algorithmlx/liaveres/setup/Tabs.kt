package com.algorithmlx.liaveres.setup

import com.algorithmlx.liaveres.LiaVeresKotlin
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack

class Tabs {
    object LVTab: ItemGroup(LiaVeresKotlin.Constants.ModId + LiaVeresKotlin.Constants.TabName) {
        override fun makeIcon(): ItemStack {
            return ItemStack(Registration.ItemReg.MATTER_CRYSTAL)
        }
    }
}