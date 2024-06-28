package io.github.lieonlion.lolmfv.init;

import io.github.lieonlion.lolmfv.MoreFurnaceVariants;
import io.github.lieonlion.lolmfv.block.MoreFurnaceBlock;
import io.github.lieonlion.lolmfv.block.entity.MoreFurnaceBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.MapColor;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final MoreFurnaceBlock DEEPSLATE_FURNACE = new MoreFurnaceBlock(MapColor.DEEPSLATE, SoundType.DEEPSLATE, 4.5f, "deepslate");
    public static final MoreFurnaceBlock BLACKSTONE_FURNACE = new MoreFurnaceBlock(MapColor.COLOR_BLACK, 3.0f, "blackstone");
    public static BlockEntityType<MoreFurnaceBlockEntity> MORE_FURNACE_BLOCK_ENTITY;
    public static final List<Block> blocks = new ArrayList<>();

    public static void registerBlocks() {
        registerBlock("deepslate_furnace", DEEPSLATE_FURNACE);
        registerBlock("blackstone_furnace", BLACKSTONE_FURNACE);

        MORE_FURNACE_BLOCK_ENTITY = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, MoreFurnaceVariants.asId("more_furnace"),
                BlockEntityType.Builder.of(MoreFurnaceBlockEntity::new, BlockInit.blocks.toArray(Block[]::new)).build());
    }

    private static void registerBlock(String name, Block block) {
        Registry.register(BuiltInRegistries.BLOCK, MoreFurnaceVariants.asId(name), block);
        blocks.add(block); 
    }
}