package me.bodiw.magica.core;

import me.bodiw.magica.Magica;
import me.bodiw.magica.common.block.NodeBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block NODE_BLOCK = new NodeBlock(FabricBlockSettings.of(Material.WOOL).noCollision().strength(4.0f));

    public static final Block TEST_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f, 4.0f));

    public static void registerBlocks() {
        ModBlocks.register("node", NODE_BLOCK);
        ModBlocks.register("test", TEST_BLOCK);
    }

    private static Block register(String id, Block block) {
        Magica.LOGGER.info("Registering block: " + id);
        return Registry.register(Registry.BLOCK, new Identifier("magica", id), block);
    }
}
