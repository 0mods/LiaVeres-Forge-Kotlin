package com.algorithmlx.liaveres.block

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraftforge.common.ToolType

class MatterBlock : Block(Properties.of(Material.METAL).harvestTool(ToolType.PICKAXE))