package net.cozyliving;

import net.cozyliving.block.CozyChairBlock;
import net.cozyliving.block.ModBlocks;
import net.cozyliving.item.ModItemGroup;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CozyLiving implements ModInitializer {
	public static final String MOD_ID = "cozy_living";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Cozy Living: загружаем уютную мебель...");
		ModBlocks.registerBlocks();
		ModItemGroup.registerItemGroups();

		// Убираем "невидимые сиденья" стульев, когда с них никто не встаёт
		ServerTickEvents.END_WORLD_TICK.register(world -> {
			List<ArmorStandEntity> toRemove = new ArrayList<>();
			for (Entity entity : world.iterateEntities()) {
				if (entity instanceof ArmorStandEntity stand
						&& stand.getCommandTags().contains(CozyChairBlock.SEAT_TAG)
						&& stand.getPassengerList().isEmpty()) {
					toRemove.add(stand);
				}
			}
			for (ArmorStandEntity stand : toRemove) {
				stand.discard();
			}
		});
	}
}
