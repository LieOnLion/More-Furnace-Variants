package io.github.lieonlion.lolmfv;

import io.github.lieonlion.lolmfv.init.BlockInit;
import io.github.lieonlion.lolmfv.init.ItemInit;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class MoreFurnaceVariants implements ModInitializer {
    public static final String MODID = "lolmfv";

    @Override
    public void onInitialize() {
        BlockInit.registerBlocks();
        ItemInit.registerItems();
    }

    public static Identifier asId(String id) {
        return new Identifier(MODID, id);
    }
}