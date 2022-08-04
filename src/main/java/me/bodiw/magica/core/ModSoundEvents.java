package me.bodiw.magica.core;

import me.bodiw.magica.Magica;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSoundEvents {

    public static final Identifier ENTITY_ANGEL_HURT_ID = new Identifier(Magica.MODID, "entity.angel.angel_hurt");
    public static final Identifier ENTITY_ANGEL_DEATH_ID = new Identifier(Magica.MODID, "entity.angel.angel_death");

    public static final SoundEvent ENTITY_ANGEL_HURT = new SoundEvent(ENTITY_ANGEL_HURT_ID);
    public static final SoundEvent ENTITY_ANGEL_DEATH = new SoundEvent(ENTITY_ANGEL_DEATH_ID);

    public static void registerSoundEvents() {
        Registry.register(Registry.SOUND_EVENT, ENTITY_ANGEL_HURT_ID, ENTITY_ANGEL_HURT);
        Registry.register(Registry.SOUND_EVENT, ENTITY_ANGEL_DEATH_ID, ENTITY_ANGEL_DEATH);
    }

}
