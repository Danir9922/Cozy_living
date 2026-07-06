package net.cozyliving.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class CozySofaBlock extends Block {

	private static final VoxelShape SHAPE = VoxelShapes.union(
			Block.createCuboidShape(0, 0, 0, 16, 8, 16),   // сиденье
			Block.createCuboidShape(0, 8, 0, 16, 16, 3),   // спинка
			Block.createCuboidShape(0, 0, 0, 3, 14, 16),   // левый подлокотник
			Block.createCuboidShape(13, 0, 0, 16, 14, 16)  // правый подлокотник
	);

	public CozySofaBlock(Settings settings) {
		super(settings);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return SHAPE;
	}
}
