package com.gmail.lemonicplus.stonelavas.lava.fluid.lavas;

import com.gmail.lemonicplus.stonelavas.StoneLavaBlocks;
import com.gmail.lemonicplus.stonelavas.StoneLavaBuckets;
import com.gmail.lemonicplus.stonelavas.lava.fluid.StoneLavaFluids;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public class CalciteLavaFluid extends AbstractLavaFluid {
    @Override
    public Fluid getFlowing() {
        return StoneLavaFluids.FLOWING_CALCITE_LAVA;
    }

    @Override
    public Fluid getSource() {
        return StoneLavaFluids.CALCITE_LAVA;
    }

    @Override
    public Item getBucket() {
        return StoneLavaBuckets.CALCITE_LAVA_BUCKET.get();
    }


    @Override
    protected BlockState createLegacyBlock(FluidState fluidState) {
        return StoneLavaBlocks.CALCITE_LAVA.get().defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(fluidState));
    }

    public static class Flowing extends CalciteLavaFluid {
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> fluidStateBuilder) {
            super.createFluidStateDefinition(fluidStateBuilder);
            fluidStateBuilder.add(LEVEL);
        }

        public int getAmount(FluidState fluidState) {
            return fluidState.getValue(LEVEL);
        }

        public boolean isSource(FluidState fluidState) {
            return false;
        }
    }

    public static class Source extends CalciteLavaFluid {
        public int getAmount(FluidState fluidState) {
            return 8;
        }

        public boolean isSource(FluidState fluidState) {
            return true;
        }
    }
}
