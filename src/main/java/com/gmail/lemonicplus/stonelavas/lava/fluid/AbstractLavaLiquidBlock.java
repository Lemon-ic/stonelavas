package com.gmail.lemonicplus.stonelavas.lava.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidInteractionRegistry.FluidInteraction;

public class AbstractLavaLiquidBlock extends LiquidBlock implements FluidInteraction {
    private final FlowingFluid fluid;
    public AbstractLavaLiquidBlock(FlowingFluid flowingFluid, BlockBehaviour.Properties properties) {
        super(flowingFluid, properties);
        this.fluid = flowingFluid;
    }

    private Block setStone(FlowingFluid flowingFluid){
        if (flowingFluid.equals(StoneLavaFluids.FLOWING_GRANITE_LAVA)) {
            return Blocks.GRANITE;
        } else if (flowingFluid.equals(StoneLavaFluids.FLOWING_DIORITE_LAVA)) {
            return Blocks.DIORITE;
        } else if (flowingFluid.equals(StoneLavaFluids.FLOWING_ANDESITE_LAVA)) {
            return Blocks.ANDESITE;
        } else if (flowingFluid.equals(StoneLavaFluids.FLOWING_DEEPSLATE_LAVA)) {
            return Blocks.COBBLED_DEEPSLATE;
        } else if (flowingFluid.equals(StoneLavaFluids.FLOWING_CALCITE_LAVA)) {
            return Blocks.CALCITE;
        } else if (flowingFluid.equals(StoneLavaFluids.FLOWING_TUFF_LAVA)) {
            return Blocks.TUFF;
        } else return Blocks.COBBLESTONE;
    }


    private boolean shouldSpreadLiquid(Level level, BlockPos blockPos, BlockState blockState) {
        if (this.fluid.is(FluidTags.LAVA)) {
            for(Direction direction : POSSIBLE_FLOW_DIRECTIONS) {
                BlockPos blockpos = blockPos.relative(direction.getOpposite());
                if (level.getFluidState(blockpos).is(FluidTags.WATER)) {
                    Block block = level.getFluidState(blockPos).isSource() ? Blocks.OBSIDIAN : setStone(this.fluid);
                    level.setBlockAndUpdate(blockPos, block.defaultBlockState());
                    this.fizz(level, blockPos);
                    return false;
                }

                if (level.getBlockState(blockPos.below()).is(Blocks.SOUL_SOIL) && level.getBlockState(blockpos).is(Blocks.BLUE_ICE)) {
                    level.setBlockAndUpdate(blockPos, Blocks.BASALT.defaultBlockState());
                    this.fizz(level, blockPos);
                    return false;
                }
            }
        }

        return true;
    }
    private void fizz(LevelAccessor levelAccessor, BlockPos blockPos) {
        levelAccessor.levelEvent(1501, blockPos, 0);
    }


    @Override
    public void interact(Level level, BlockPos currentPos, BlockPos relativePos, FluidState currentState) {


    }
}
