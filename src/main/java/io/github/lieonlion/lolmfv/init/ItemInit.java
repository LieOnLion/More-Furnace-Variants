package io.github.lieonlion.lolmfv.init;

import io.github.lieonlion.lolmfv.MoreFurnaceVariants;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemInit {
    public static BlockItem DEEPSLATE_FURNACE_I = new BlockItem(BlockInit.DEEPSLATE_FURNACE, (new Item.Settings()));
    public static BlockItem BLACKSTONE_FURNACE_I = new BlockItem(BlockInit.BLACKSTONE_FURNACE, (new Item.Settings()));

    public static void registerItems() {
        registerItem("deepslate_furnace", DEEPSLATE_FURNACE_I, Items.FURNACE);
        registerItem("blackstone_furnace", BLACKSTONE_FURNACE_I, DEEPSLATE_FURNACE_I);
    }

    public static void registerItem(String name, Item item, Item after) {
        Registry.register(Registries.ITEM, new Identifier(MoreFurnaceVariants.MODID, name), item);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.addAfter(after, item));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> entries.addAfter(after, item));
    }
}