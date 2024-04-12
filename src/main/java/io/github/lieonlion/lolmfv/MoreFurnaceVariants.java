package io.github.lieonlion.lolmfv;

import io.github.lieonlion.lolmfv.init.BlockInit;
import io.github.lieonlion.lolmfv.init.ItemInit;
import net.fabricmc.api.ModInitializer;

public class MoreFurnaceVariants implements ModInitializer {
    public static final String MODID = "lolmfv";

    @Override
    public void onInitialize() {
        BlockInit.registerBlocks();
        ItemInit.registerItems();
    }
}