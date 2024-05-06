package io.github.lieonlion.lolmfv.init;

import io.github.lieonlion.lolmfv.MoreFurnaceVariants;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MoreFurnaceVariants.MODID);

    public static DeferredItem<BlockItem> DEEPSLATE_FURNACE_I = registerItem("deepslate_furnace", BlockInit.DEEPSLATE_FURNACE);
    public static DeferredItem<BlockItem> BLACKSTONE_FURNACE_I = registerItem("blackstone_furnace", BlockInit.BLACKSTONE_FURNACE);

    public static void registerItems(IEventBus modBus) {
        ITEMS.register(modBus);
    }

    public static DeferredItem<BlockItem> registerItem(String name, DeferredBlock<Block> block) {
        return ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void addItemsToTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() != CreativeModeTabs.FUNCTIONAL_BLOCKS && event.getTabKey() != CreativeModeTabs.REDSTONE_BLOCKS) return;
        registerToTab(event, DEEPSLATE_FURNACE_I.get(), Items.FURNACE);
        registerToTab(event, BLACKSTONE_FURNACE_I.get(), DEEPSLATE_FURNACE_I.get());
    } public static void registerToTab(BuildCreativeModeTabContentsEvent event, Item item, Item after) {
        event.getEntries().putAfter(new ItemStack(after), new ItemStack(item), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
}