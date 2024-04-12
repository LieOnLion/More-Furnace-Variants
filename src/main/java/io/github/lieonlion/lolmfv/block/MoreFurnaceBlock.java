package io.github.lieonlion.lolmfv.block;

import io.github.lieonlion.lolmfv.block.entity.MoreFurnaceBlockEntity;
import io.github.lieonlion.lolmfv.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Nullable;

import java.util.function.ToIntFunction;

public class MoreFurnaceBlock extends FurnaceBlock {
    public String type;

    public MoreFurnaceBlock(MapColor colour, float strength, String type) {
        super(Properties.of().mapColor(colour).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(strength).lightLevel(litFurnaceLightLevel()));
        this.type = type;
    }
    public MoreFurnaceBlock(MapColor colour, SoundType sound, float strength, String type) {
        super(Properties.of().mapColor(colour).sound(sound).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(strength).lightLevel(litFurnaceLightLevel()));
        this.type = type;
    }

    private static ToIntFunction<BlockState> litFurnaceLightLevel() {
        return (blockState) -> {
            return (Boolean) blockState.getValue(BlockStateProperties.LIT) ? 13 : 0;
        };
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return MoreFurnaceBlock.createFurnaceTicker(level, type, BlockInit.MORE_FURNACE_BLOCK_ENTITY.get());
    }

    @Override
    protected void openContainer(Level level, BlockPos pos, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof MoreFurnaceBlockEntity) {
            player.openMenu((MenuProvider)blockEntity);
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MoreFurnaceBlockEntity(pos, state);
    }

    public String getType() {
        return type;
    }
}
