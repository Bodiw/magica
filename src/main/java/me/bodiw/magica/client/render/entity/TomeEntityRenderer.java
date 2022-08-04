package me.bodiw.magica.client.render.entity;

import me.bodiw.magica.Magica;
import me.bodiw.magica.client.MagicaClient;
import me.bodiw.magica.client.render.entity.model.TomeEntityModel;
import me.bodiw.magica.common.entity.tome.TomeEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class TomeEntityRenderer extends MobEntityRenderer<TomeEntity, TomeEntityModel> {

    public TomeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new TomeEntityModel(context.getPart(MagicaClient.MODEL_CUBE_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(TomeEntity entity) {
        return new Identifier(Magica.MODID, "textures/entity/tome.png");
    }
}
