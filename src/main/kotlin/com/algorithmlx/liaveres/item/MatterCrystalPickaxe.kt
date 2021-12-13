package com.algorithmlx.liaveres.item

import com.algorithmlx.liaveres.LiaVeresKotlin.Constants.ModId
import com.algorithmlx.liaveres.api.LVItemTiers
import com.algorithmlx.liaveres.setup.Tabs.*
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.TranslatableComponent
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.InteractionResult
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.PickaxeItem
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.level.Level


class MatterCrystalPickaxe :
    PickaxeItem(LVItemTiers.MATTER_CRYSTAL, 2147483647, 340282356779733661637539395458142568447F, Properties().tab(LVTab).fireResistant()) {
    private var skip = false
    override fun useOn(context: UseOnContext): InteractionResult {
        val player = context.player
        val pos = context.clickedPos
        val itemStack = context.itemInHand
        if (player == null) return InteractionResult.FAIL
        val world = context.player!!.level
        if (!world.isClientSide() && !player.isShiftKeyDown && !player.cooldowns.isOnCooldown(itemStack.item) && player is ServerPlayer) {
            if (!skip) {
                val blocks: MutableList<BlockPos> = ArrayList()
                for (x in 0..31) {
                    for (y in 0..31) {
                        for (z in 0..31) {
                            val posX = pos.x
                            val posY = pos.y
                            val posZ = pos.z
                            when (player.direction) {
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

    override fun appendHoverText(p_41421_: ItemStack, p_41422_: Level?, p_41423_: MutableList<Component>, p_41424_: TooltipFlag) {
        p_41423_.add(TranslatableComponent("msg.$ModId.matter_crystal_pickaxe"))
        p_41423_.add(TranslatableComponent("msg.$ModId.matter_crystal_msg"))
    }
}