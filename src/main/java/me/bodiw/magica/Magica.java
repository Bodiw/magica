package me.bodiw.magica;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.bodiw.magica.core.ModBlockEntities;
import me.bodiw.magica.core.ModBlocks;
import me.bodiw.magica.core.ModEntities;
import me.bodiw.magica.core.ModItems;
import me.bodiw.magica.core.ModSoundEvents;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class Magica implements ModInitializer {
	public static final String MODID = "magica";

	public static final Logger LOGGER = LoggerFactory.getLogger(Magica.MODID);

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(Magica.MODID, "general")).icon(() -> new ItemStack(Items.ECHO_SHARD)).build();

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModSoundEvents.registerSoundEvents();
		ModBlocks.registerBlocks();
		ModBlockEntities.registerBlockEntities();
		ModItems.registerItems();
		ModEntities.registerEntities();
	}
}
