package io.github.lieonlion.lolmfv;

import io.github.lieonlion.lolmfv.init.BlockInit;
import io.github.lieonlion.lolmfv.init.ItemInit;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(MoreFurnaceVariants.MODID)
public class MoreFurnaceVariants {
    public static final String MODID = "lolmfv";

    public MoreFurnaceVariants(IEventBus modBus) {
        BlockInit.registerBlocks(modBus);
        ItemInit.registerItems(modBus);

        modBus.addListener(ItemInit::addItemsToTab);
    }
}