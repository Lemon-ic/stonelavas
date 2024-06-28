package com.gmail.lemonicplus.stonelavas.lava.fluid.lavas;

import com.gmail.lemonicplus.stonelavas.lava.init.StoneLavaBlocks;
import com.gmail.lemonicplus.stonelavas.lava.init.StoneLavaBuckets;
import com.gmail.lemonicplus.stonelavas.lava.init.StoneLavaFluids;
import com.gmail.lemonicplus.stonelavas.lava.init.StoneLavaTypes;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class DioriteLavaFluid extends AbstractLavaFluid {

    public static final ForgeFlowingFluid.Properties properties = new ForgeFlowingFluid.Properties(
            StoneLavaTypes.DIORITE_TYPE,
            StoneLavaFluids.DIORITE_LAVA,
            StoneLavaFluids.FLOWING_DIORITE_LAVA)
            .explosionResistance(100f)
            .tickRate(30)
            .bucket(StoneLavaBuckets.DIORITE_LAVA_BUCKET)
            .block(() -> (LiquidBlock) StoneLavaBlocks.DIORITE_LAVA_BLOCK.get());

    protected DioriteLavaFluid() {
        super(properties);
    }

    @Override
    public Fluid getFlowing() {
        return StoneLavaFluids.FLOWING_DIORITE_LAVA.get();
    }

    @Override
    public Fluid getSource() {
        return StoneLavaFluids.DIORITE_LAVA.get();
    }

    @Override
    public Item getBucket() {
        return StoneLavaBuckets.DIORITE_LAVA_BUCKET.get();
    }


    @Override
    protected BlockState createLegacyBlock(FluidState fluidState) {
        return StoneLavaBlocks.DIORITE_LAVA_BLOCK.get().defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(fluidState));
    }

    public static class Flowing extends DioriteLavaFluid {

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

    public static class Source extends DioriteLavaFluid {

        public int getAmount(FluidState fluidState) {
            return 8;
        }

        public boolean isSource(FluidState fluidState) {
            return true;
        }
    }
}
