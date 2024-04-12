package io.github.lieonlion.lolmfv.init;

import io.github.lieonlion.lolmfv.MoreFurnaceVariants;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreFurnaceVariants.MODID);

    public static RegistryObject<BlockItem> DEEPSLATE_FURNACE_I = registerItem("deepslate_furnace", BlockInit.DEEPSLATE_FURNACE);
    public static RegistryObject<BlockItem> BLACKSTONE_FURNACE_I = registerItem("blackstone_furnace", BlockInit.BLACKSTONE_FURNACE);

    public static void registerItems(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

    public static RegistryObject<BlockItem> registerItem(String name, RegistryObject<Block> block) {
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