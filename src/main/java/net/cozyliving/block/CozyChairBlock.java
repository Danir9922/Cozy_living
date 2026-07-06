package net.cozyliving.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CozyChairBlock extends Block {

	// Метка в NBT, чтобы отличать наши "сиденья" от обычных подставок для брони
	public static final String SEAT_TAG = "CozyLivingSeat";

	private static final VoxelShape SHAPE = VoxelShapes.union(
			Block.createCuboidShape(2, 7, 2, 14, 9, 14),   // сиденье
			Block.createCuboidShape(2, 9, 2, 14, 16, 4),   // спинка
			Block.createCuboidShape(2, 0, 2, 4, 7, 4),     // ножка
			Block.createCuboidShape(12, 0, 2, 14, 7, 4),   // ножка
			Block.createCuboidShape(2, 0, 12, 4, 7, 14),   // ножка
			Block.createCuboidShape(12, 0, 12, 14, 7, 14)  // ножка
	);

	public CozyChairBlock(Settings settings) {
		super(settings);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return SHAPE;
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (world.isClient) {
			return ActionResult.SUCCESS;
		}

		// Если у игрока уже есть "средство передвижения" - не сажаем повторно
		if (player.getVehicle() != null) {
			return ActionResult.PASS;
		}

		ArmorStandEntity seat = new ArmorStandEntity(EntityType.ARMOR_STAND, world);
		seat.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY() + 0.3, pos.getZ() + 0.5, 0, 0);
		seat.setInvisible(true);
		seat.setInvulnerable(true);
		seat.setNoGravity(true);
		seat.setSilent(true);
		seat.setShowArms(false);
		seat.addCommandTag(SEAT_TAG);

		world.spawnEntity(seat);
		player.startRiding(seat);

		return ActionResult.CONSUME;
	}
}
