package me.bodiw.magica.client.render.entity.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.EnchantingTableBlockEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BookModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.math.random.Random;

@Environment(value = EnvType.CLIENT)
public class TomeFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {

    private final BookModel model;

    public float nextPageAngle;
    public float pageAngle;
    public float flipRandom;
    public float flipTurn;
    public float nextPageTurningSpeed;
    public float pageTurningSpeed;
    public float bookRotation;
    public float lastBookRotation;
    public float targetBookRotation;
    public float bookPitch;
    private static final Random RANDOM = Random.create();

    public TomeFeatureRenderer(FeatureRendererContext<T, M> featureRendererContext, EntityModelLoader loader) {
        super(featureRendererContext);
        this.model = new BookModel(loader.getModelPart(EntityModelLayers.BOOK));
    }

    /**
     * @param i light
     * @param f limbAngle
     * @param g limbDistance
     * @param h tickDelta
     * @param j animationProgress
     * @param k headYaw
     * @param l headPitch
     */
    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertices, int light, T entity, float f, float g, float tickDelta, float j, float k, float l) {
        matrices.push();
        double offset = Math.sin((entity.getWorld().getTime() + tickDelta) / 8.0) / 4.0;
        double offsetZ = Math.cos((entity.getWorld().getTime() + tickDelta) / 8.0) / 4.0;
        float bodyYaw = MathHelper.lerpAngleDegrees(tickDelta, entity.prevBodyYaw, entity.bodyYaw);

        // Cancel the bodyYaw rotation
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(-bodyYaw + 10));

        // Rotate around the player
        matrices.translate(offset * 3, 0 + offset, offsetZ * 3);

        // Aim as the player head
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(entity.getHeadYaw() + 90));

        // Inclinate the tome
        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(-20 + entity.getPitch()));
        VertexConsumer vertexConsumer = EnchantingTableBlockEntityRenderer.BOOK_TEXTURE.getVertexConsumer(vertices, RenderLayer::getEntitySolid);
        this.model.setPageAngles(0.0f, 0.2f, 0.8f, 0.4f);
        this.model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
        matrices.pop();

    }

}
