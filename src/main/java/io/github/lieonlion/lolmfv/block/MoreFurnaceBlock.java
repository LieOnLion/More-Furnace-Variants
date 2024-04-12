package io.github.lieonlion.lolmfv.block;

import io.github.lieonlion.lolmfv.block.entity.MoreFurnaceBlockEntity;
import io.github.lieonlion.lolmfv.init.BlockInit;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MoreFurnaceBlock extends FurnaceBlock {
    public String type;

    public MoreFurnaceBlock(MapColor colour, float strength, String type) {
        super(Settings.copy(Blocks.FURNACE).strength(strength).mapColor(colour));
        this.type = type;
    }
    public MoreFurnaceBlock(MapColor colour, BlockSoundGroup sound, float strength, String type) {
        super(Settings.copy(Blocks.FURNACE).mapColor(colour).strength(strength).sounds(sound));
        this.type = type;
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return MoreFurnaceBlock.validateTicker(world, type, BlockInit.MORE_FURNACE_BLOCK_ENTITY);
    }

    @Override
    protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof MoreFurnaceBlockEntity) {
            player.openHandledScreen((NamedScreenHandlerFactory)blockEntity);
            player.incrementStat(Stats.INTERACT_WITH_FURNACE);
        }
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MoreFurnaceBlockEntity(pos, state);
    }

    public String getType() {
        return type;
    }
}