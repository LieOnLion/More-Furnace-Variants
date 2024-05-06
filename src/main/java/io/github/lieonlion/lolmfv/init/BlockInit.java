package io.github.lieonlion.lolmfv.init;

import io.github.lieonlion.lolmfv.MoreFurnaceVariants;
import io.github.lieonlion.lolmfv.block.MoreFurnaceBlock;
import io.github.lieonlion.lolmfv.block.entity.MoreFurnaceBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BlockInit {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MoreFurnaceVariants.MODID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCKS_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MoreFurnaceVariants.MODID);

    public static final DeferredBlock<Block> DEEPSLATE_FURNACE = registerBlock("deepslate_furnace", () -> new MoreFurnaceBlock(MapColor.DEEPSLATE, SoundType.DEEPSLATE, 4.5f, "deepslate"));
    public static final DeferredBlock<Block> BLACKSTONE_FURNACE = registerBlock("blackstone_furnace", () -> new MoreFurnaceBlock(MapColor.DEEPSLATE, 3.0f, "blackstone"));
    public static Supplier<BlockEntityType<MoreFurnaceBlockEntity>> MORE_FURNACE_BLOCK_ENTITY;
    public static final List<DeferredBlock<Block>> blocks = new ArrayList<>();

    public static void registerBlocks(IEventBus modBus) {
        addToArray(DEEPSLATE_FURNACE);
        addToArray(BLACKSTONE_FURNACE);

        MORE_FURNACE_BLOCK_ENTITY = BLOCKS_ENTITIES.register("more_furnace",
                () -> BlockEntityType.Builder.of(MoreFurnaceBlockEntity::new, blocks.stream().map(DeferredBlock::get).toArray(Block[]::new)).build(null));

        BLOCKS.register(modBus);
        BLOCKS_ENTITIES.register(modBus);
    }

    private static DeferredBlock<Block> registerBlock(String name, Supplier<Block> block) {
        return BLOCKS.register(name, block);
    }

    private static void addToArray(DeferredBlock<Block> block) {
        blocks.add(block);
    }
}