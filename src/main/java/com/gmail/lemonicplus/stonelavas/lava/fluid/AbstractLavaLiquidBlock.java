package com.gmail.lemonicplus.stonelavas.lava.fluid;

import com.gmail.lemonicplus.stonelavas.lava.init.StoneLavaFluids;
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

public class AbstractLavaLiquidBlock extends LiquidBlock{
    private final FlowingFluid fluid;
    public AbstractLavaLiquidBlock(FlowingFluid flowingFluid, BlockBehaviour.Properties properties) {
        super(flowingFluid, properties);
        this.fluid = flowingFluid;
    }
}
