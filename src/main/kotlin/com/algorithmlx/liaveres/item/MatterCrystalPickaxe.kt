package com.algorithmlx.liaveres.item

import com.algorithmlx.liaveres.LiaVeresKotlin.Constants.ModId
import com.algorithmlx.liaveres.api.LVItemTiers
import com.algorithmlx.liaveres.setup.Tabs.*
import net.minecraft.client.util.ITooltipFlag
import net.minecraft.entity.player.ServerPlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUseContext
import net.minecraft.item.PickaxeItem
import net.minecraft.util.ActionResultType
import net.minecraft.util.Direction
import net.minecraft.util.math.BlockPos
import net.minecraft.util.text.ITextComponent
import net.minecraft.util.text.TranslationTextComponent
import net.minecraft.world.World


class MatterCrystalPickaxe :
    PickaxeItem(LVItemTiers.MATTER_CRYSTAL, 2147483647, 340282356779733661637539395458142568447F, Properties().tab(LVTab).fireResistant()) {
    private var skip = false
    override fun useOn(context: ItemUseContext): ActionResultType {
        val player = context.player
        val pos = context.clickedPos
        val itemStack = context.itemInHand
        if (player == null) return ActionResultType.FAIL
        val world = context.player!!.entity.level
        if (!world.isClientSide() && !player.isShiftKeyDown && !player.cooldowns.isOnCooldown(itemStack.item) && player is ServerPlayerEntity) {
            if (!skip) {
                val blocks: MutableList<BlockPos> = ArrayList()
                for (x in 0..31) {
                    for (y in 0..31) {
                        for (z in 0..31) {
                            val posX = pos.x
                            val posY = pos.y
                            val posZ = pos.z
                            when (player.getDirection()) {
                                Direction.SOUTH -> blocks.add(BlockPos(posX + 17 - x, posY - 1 + y, posZ + z))
                                Direction.NORTH -> blocks.add(BlockPos(posX - 17 + x, posY - 1 + y, posZ - z))
                                Direction.EAST -> blocks.add(BlockPos(posX + x, posY - 1 + y, posZ + 17 - z))
                                Direction.WEST -> blocks.add(BlockPos(posX - x, posY - 1 + y, posZ - 17 + z))
                            }
                        }
                    }
                }
                skip = true
                for (position in blocks) {
                    val state = world.getBlockState(position)
                    if (!state.isAir) {
                        player.gameMode.destroyBlock(position)
                    }
                }
                skip = false
            }
            player.getCooldowns().addCooldown(this, 240)
        }
        return super.useOn(context)
    }
    override fun hasContainerItem(stack: ItemStack?): Boolean {
        return true
    }

    override fun getContainerItem(itemStack: ItemStack?): ItemStack {
        return itemStack!!.copy()
    }
    override fun appendHoverText(p_77624_1_: ItemStack, p_77624_2_: World?, p_77624_3_: MutableList<ITextComponent>, p_77624_4_: ITooltipFlag) {
        p_77624_3_.add(TranslationTextComponent("msg.$ModId.matter_crystal_pickaxe"))
        p_77624_3_.add(TranslationTextComponent("msg.$ModId.matter_crystal_msg"))
    }
}