package io.github.lieonlion.lolmfv.init;

import io.github.lieonlion.lolmfv.MoreFurnaceVariants;
import io.github.lieonlion.lolmfv.block.MoreFurnaceBlock;
import io.github.lieonlion.lolmfv.block.entity.MoreFurnaceBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final MoreFurnaceBlock DEEPSLATE_FURNACE = new MoreFurnaceBlock(MapColor.DEEPSLATE_GRAY, BlockSoundGroup.DEEPSLATE, 4.5f, "deepslate");
    public static final MoreFurnaceBlock BLACKSTONE_FURNACE = new MoreFurnaceBlock(MapColor.BLACK, 3.0f, "blackstone");
    public static BlockEntityType<MoreFurnaceBlockEntity> MORE_FURNACE_BLOCK_ENTITY;
    public static final List<Block> blocks = new ArrayList<>();

    public static void registerBlocks() {
        registerBlock("deepslate_furnace", DEEPSLATE_FURNACE);
        registerBlock("blackstone_furnace", BLACKSTONE_FURNACE);

        MORE_FURNACE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(MoreFurnaceVariants.MODID, "more_furnace"),
                BlockEntityType.Builder.create(MoreFurnaceBlockEntity::new, BlockInit.blocks.toArray(Block[]::new)).build());
    }

    private static void registerBlock(String name, Block block) {
        Registry.register(Registries.BLOCK, new Identifier(MoreFurnaceVariants.MODID, name), block);
        blocks.add(block); 
    }
}