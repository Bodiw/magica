package me.bodiw.magica.common.entity.tome;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableShoulderEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class TomeEntity extends TameableShoulderEntity{

    public TomeEntity(EntityType<? extends TameableShoulderEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public PassiveEntity createChild(ServerWorld var1, PassiveEntity var2) {
        return null;
    }
}
