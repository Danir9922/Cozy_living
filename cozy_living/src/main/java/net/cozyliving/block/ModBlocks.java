package net.cozyliving.block;

import net.cozyliving.CozyLiving;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

	public static final Block COZY_LAMP = registerBlock("cozy_lamp",
			new CozyLampBlock(AbstractBlock.Settings.create()
					.mapColor(MapColor.IRON_GRAY)
					.strength(1.0f)
					.luminance(state -> 15)
					.sounds(BlockSoundGroup.METAL)
					.nonOpaque()));

	public static final Block COZY_SOFA = registerBlock("cozy_sofa",
			new CozySofaBlock(AbstractBlock.Settings.create()
					.mapColor(MapColor.RED)
					.strength(1.5f)
					.sounds(BlockSoundGroup.WOOL)
					.nonOpaque()));

	public static final Block COZY_TABLE = registerBlock("cozy_table",
			new CozyTableBlock(AbstractBlock.Settings.create()
					.mapColor(MapColor.OAK_TAN)
					.strength(2.0f)
					.sounds(BlockSoundGroup.WOOD)
					.nonOpaque()));

	public static final Block COZY_CHAIR = registerBlock("cozy_chair",
			new CozyChairBlock(AbstractBlock.Settings.create()
					.mapColor(MapColor.OAK_TAN)
					.strength(1.5f)
					.sounds(BlockSoundGroup.WOOD)
					.nonOpaque()));

	public static final Block COZY_RUG = registerBlock("cozy_rug",
			new CozyRugBlock(AbstractBlock.Settings.create()
					.mapColor(MapColor.RED)
					.strength(0.5f)
					.sounds(BlockSoundGroup.WOOL)
					.nonOpaque()));

	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, Identifier.of(CozyLiving.MOD_ID, name), block);
	}

	private static Item registerBlockItem(String name, Block block) {
		return Registry.register(Registries.ITEM, Identifier.of(CozyLiving.MOD_ID, name),
				new BlockItem(block, new FabricItemSettings()));
	}

	public static void registerBlocks() {
		CozyLiving.LOGGER.info("Регистрируем блоки для " + CozyLiving.MOD_ID);
	}
}
