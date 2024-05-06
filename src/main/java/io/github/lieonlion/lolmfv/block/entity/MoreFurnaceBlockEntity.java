package io.github.lieonlion.lolmfv.block.entity;

import io.github.lieonlion.lolmfv.block.MoreFurnaceBlock;
import io.github.lieonlion.lolmfv.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class MoreFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public MoreFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(BlockInit.MORE_FURNACE_BLOCK_ENTITY, pos, state, RecipeType.SMELTING);
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container." + getBlock().type + "_furnace");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new FurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    protected MoreFurnaceBlock getBlock() {
        return (MoreFurnaceBlock) getCachedState().getBlock();
    }
}