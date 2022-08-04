package me.bodiw.magica.common.block;

import me.bodiw.magica.common.block.entity.NodeBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NodeBlock extends BlockWithEntity {

    public NodeBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState) this.stateManager.getDefaultState());
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new NodeBlockEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NodeBlockEntity blockEntity = (NodeBlockEntity) world.getBlockEntity(pos);
            player.sendMessage(Text.of("" + blockEntity.increaseCounter()), true);
            blockEntity.markDirty();
        }
        return ActionResult.SUCCESS;
    }
}
