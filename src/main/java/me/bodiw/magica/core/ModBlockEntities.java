package me.bodiw.magica.core;

import me.bodiw.magica.Magica;
import me.bodiw.magica.common.block.entity.NodeBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {

    public static final BlockEntityType<NodeBlockEntity> NODE_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(NodeBlockEntity::new, ModBlocks.NODE_BLOCK).build();

    public static void registerBlockEntities() {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Magica.MODID, "node_block"), NODE_BLOCK_ENTITY);
    }

}
