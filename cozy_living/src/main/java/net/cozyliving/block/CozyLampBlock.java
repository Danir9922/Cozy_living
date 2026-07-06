package net.cozyliving.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class CozyLampBlock extends Block {

	// Форма: тонкая ножка + плафон сверху (не полный куб)
	private static final VoxelShape SHAPE = VoxelShapes.union(
			Block.createCuboidShape(5, 0, 5, 11, 2, 11),   // база
			Block.createCuboidShape(7, 2, 7, 9, 10, 9),    // стойка
			Block.createCuboidShape(4, 10, 4, 12, 13, 12), // плафон
			Block.createCuboidShape(6.5, 9, 6.5, 9.5, 12, 9.5) // лампочка
	);

	public CozyLampBlock(Settings settings) {
		super(settings);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return SHAPE;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return SHAPE;
	}
}
