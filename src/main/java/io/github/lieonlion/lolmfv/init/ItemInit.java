package io.github.lieonlion.lolmfv.init;

import io.github.lieonlion.lolmfv.MoreFurnaceVariants;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ItemInit {
    public static BlockItem DEEPSLATE_FURNACE_I = new BlockItem(BlockInit.DEEPSLATE_FURNACE, (new Item.Properties()));
    public static BlockItem BLACKSTONE_FURNACE_I = new BlockItem(BlockInit.BLACKSTONE_FURNACE, (new Item.Properties()));

    public static void registerItems() {
        registerItem("deepslate_furnace", DEEPSLATE_FURNACE_I, Items.FURNACE);
        registerItem("blackstone_furnace", BLACKSTONE_FURNACE_I, DEEPSLATE_FURNACE_I);
    }

    public static void registerItem(String name, Item item, Item after) {
        Registry.register(BuiltInRegistries.ITEM, MoreFurnaceVariants.asId(name), item);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> entries.addAfter(after, item));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(entries -> entries.addAfter(after, item));
    }
}