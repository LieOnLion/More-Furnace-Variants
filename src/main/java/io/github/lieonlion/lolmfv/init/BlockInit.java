package io.github.lieonlion.lolmfv.init;

import io.github.lieonlion.lolmfv.MoreFurnaceVariants;
import io.github.lieonlion.lolmfv.block.MoreFurnaceBlock;
import io.github.lieonlion.lolmfv.block.entity.MoreFurnaceBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BlockInit {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreFurnaceVariants.MODID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCKS_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MoreFurnaceVariants.MODID);

    public static final RegistryObject<Block> DEEPSLATE_FURNACE = registerBlock("deepslate_furnace", () -> new MoreFurnaceBlock(MapColor.DEEPSLATE, SoundType.DEEPSLATE, 4.5f, "deepslate"));
    public static final RegistryObject<Block> BLACKSTONE_FURNACE = registerBlock("blackstone_furnace", () -> new MoreFurnaceBlock(MapColor.DEEPSLATE, 3.0f, "blackstone"));
    public static RegistryObject<BlockEntityType<MoreFurnaceBlockEntity>> MORE_FURNACE_BLOCK_ENTITY;
    public static final List<RegistryObject<Block>> blocks = new ArrayList<>();

    public static void registerBlocks(IEventBus modEventBus) {
        addToArray(DEEPSLATE_FURNACE);
        addToArray(BLACKSTONE_FURNACE);

        MORE_FURNACE_BLOCK_ENTITY = BLOCKS_ENTITIES.register("more_furnace",
                () -> BlockEntityType.Builder.of(MoreFurnaceBlockEntity::new, blocks.stream().map(RegistryObject::get).toArray(Block[]::new)).build(null));

        BLOCKS.register(modEventBus);
        BLOCKS_ENTITIES.register(modEventBus);
    }

    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
        return BLOCKS.register(name, block);
    }

    private static void addToArray(RegistryObject<Block> block) {
        blocks.add(block);
    }
}