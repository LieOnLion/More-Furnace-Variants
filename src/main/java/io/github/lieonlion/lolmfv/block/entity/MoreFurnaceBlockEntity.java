package io.github.lieonlion.lolmfv.block.entity;

import io.github.lieonlion.lolmfv.block.MoreFurnaceBlock;
import io.github.lieonlion.lolmfv.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MoreFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public MoreFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(BlockInit.MORE_FURNACE_BLOCK_ENTITY.get(), pos, state, RecipeType.SMELTING);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container." + getBlock().getType() + "_furnace");
    }

    @Override
    protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
        return new FurnaceMenu(syncId, playerInventory, this, this.dataAccess);
    }

    protected MoreFurnaceBlock getBlock() {
        if (!this.getLevel().isClientSide)
            return (MoreFurnaceBlock) getBlockState().getBlock();
        return null;
    }
}