package me.bodiw.magica.core;

import me.bodiw.magica.Magica;
import me.bodiw.magica.common.entity.tome.TomeEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<TomeEntity> TOME_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TomeEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build();

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(TOME_ENTITY, TomeEntity.createMobAttributes());
    }

    public static void registerEntities() {
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Magica.MODID, "tome_entity"), TOME_ENTITY);
        registerAttributes();
    }
}
