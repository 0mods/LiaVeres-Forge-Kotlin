package com.algorithmlx.liaveres

import com.algorithmlx.javaModule.liaveres.RegistryOther
import com.algorithmlx.javaModule.liaveres.world.gen.OreGen
import com.algorithmlx.liaveres.LiaVeresKotlin.Constants.ModId
import com.algorithmlx.liaveres.setup.Registration
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod(ModId)
class LiaVeresKotlin {
    val LOGGER: Logger = LogManager.getLogger()

    init {
        val modBus = FMLJavaModLoadingContext.get().modEventBus
        modBus.register(Registration.ItemRegister())
        modBus.register(Registration.BlockRegister())

        RegistryOther.init()
    }
    object Constants {
        const val ModId: String = "liaveres"
        const val TabName: String = ".tab"
    }

    private fun modSetup(event: FMLCommonSetupEvent) {
        OreGen.ores()
    }
}