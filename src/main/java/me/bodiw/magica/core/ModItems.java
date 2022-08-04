package me.bodiw.magica.core;

import me.bodiw.magica.Magica;
import me.bodiw.magica.common.item.ShulkerWandItem;
import me.bodiw.magica.common.item.TomeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item SHULKER_WAND = new ShulkerWandItem(ModItems.magicaSettings().maxCount(1));
    public static final Item TOME = new TomeItem(ModItems.magicaSettings().maxCount(1));

    public static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Magica.MODID, id), item);
    }

    public static FabricItemSettings magicaSettings() {
        return new FabricItemSettings().group(Magica.ITEM_GROUP);
    }

    public static void registerItems() {
        ModItems.register("shulker_wand", SHULKER_WAND);
        ModItems.register("tome_book", TOME);
    }
}
