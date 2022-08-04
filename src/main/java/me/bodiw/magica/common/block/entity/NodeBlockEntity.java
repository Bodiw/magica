package me.bodiw.magica.common.block.entity;

import me.bodiw.magica.core.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class NodeBlockEntity extends BlockEntity {

    private int counter;

    public NodeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.NODE_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);

        counter = tag.getInt("counter");
    }

    @Override
    public void writeNbt(NbtCompound tag) {
        tag.putInt("counter", counter);

        super.writeNbt(tag);
    }

    public int getCounter() {
        return counter;
    }

    public int increaseCounter() {
        return ++counter;
    }
}
