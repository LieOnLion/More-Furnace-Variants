package io.github.lieonlion.lolmfv;

import io.github.lieonlion.lolmfv.init.BlockInit;
import io.github.lieonlion.lolmfv.init.ItemInit;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

public class MoreFurnaceVariants implements ModInitializer {
    public static final String MODID = "lolmfv";

    @Override
    public void onInitialize() {
        BlockInit.registerBlocks();
        ItemInit.registerItems();
    }

    public static ResourceLocation asId(String id) {
        return ResourceLocation.fromNamespaceAndPath(MODID, id);
    }
}