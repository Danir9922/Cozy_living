package net.cozyliving.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class CozyTableBlock extends Block {

	private static final VoxelShape SHAPE = VoxelShapes.union(
			Block.createCuboidShape(0, 13, 0, 16, 15, 16),  // столешница
			Block.createCuboidShape(1, 0, 1, 3, 13, 3),     // ножка
			Block.createCuboidShape(13, 0, 1, 15, 13, 3),   // ножка
			Block.createCuboidShape(1, 0, 13, 3, 13, 15),   // ножка
			Block.createCuboidShape(13, 0, 13, 15, 13, 15)  // ножка
	);

	public CozyTableBlock(Settings settings) {
		super(settings);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return SHAPE;
	}
}
