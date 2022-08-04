package me.bodiw.magica.client;

import me.bodiw.magica.Magica;
import me.bodiw.magica.client.render.block.NodeBlockEntityRenderer;
import me.bodiw.magica.client.render.entity.TomeEntityRenderer;
import me.bodiw.magica.client.render.entity.model.TomeEntityModel;
import me.bodiw.magica.core.ModBlockEntities;
import me.bodiw.magica.core.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class MagicaClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(new Identifier(Magica.MODID, "cube"), "main");

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.TOME_ENTITY, (context) -> {
            return new TomeEntityRenderer(context);
        });

        EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, TomeEntityModel::getTexturedModelData);

        BlockEntityRendererRegistry.register(ModBlockEntities.NODE_BLOCK_ENTITY, NodeBlockEntityRenderer::new);
    }
}
