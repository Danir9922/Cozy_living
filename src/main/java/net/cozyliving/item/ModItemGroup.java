package net.cozyliving.item;

import net.cozyliving.CozyLiving;
import net.cozyliving.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

	public static final RegistryKey<ItemGroup> COZY_LIVING_GROUP_KEY = RegistryKey.of(
			RegistryKeys.ITEM_GROUP,
			Identifier.of(CozyLiving.MOD_ID, "cozy_living_group")
	);

	public static void registerItemGroups() {
		Registry.register(Registries.ITEM_GROUP, COZY_LIVING_GROUP_KEY, FabricItemGroup.builder()
				.displayName(Text.translatable("itemgroup.cozy_living.cozy_living_group"))
				.icon(() -> new ItemStack(ModBlocks.COZY_LAMP))
				.entries((displayContext, entries) -> {
					entries.add(ModBlocks.COZY_LAMP);
					entries.add(ModBlocks.COZY_SOFA);
					entries.add(ModBlocks.COZY_TABLE);
					entries.add(ModBlocks.COZY_CHAIR);
					entries.add(ModBlocks.COZY_RUG);
				})
				.build());
	}
}
