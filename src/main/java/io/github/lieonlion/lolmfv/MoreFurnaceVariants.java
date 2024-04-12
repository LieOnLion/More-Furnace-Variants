package io.github.lieonlion.lolmfv;

import io.github.lieonlion.lolmfv.init.ItemInit;
import io.github.lieonlion.lolmfv.init.BlockInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoreFurnaceVariants.MODID)
public class MoreFurnaceVariants {
    public static final String MODID = "lolmfv";

    public MoreFurnaceVariants() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockInit.registerBlocks(modEventBus);
        ItemInit.registerItems(modEventBus);

        modEventBus.addListener(ItemInit::addItemsToTab);

        MinecraftForge.EVENT_BUS.register(this);
    }
}