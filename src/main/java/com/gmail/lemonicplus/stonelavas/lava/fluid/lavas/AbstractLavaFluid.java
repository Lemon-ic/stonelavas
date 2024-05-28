package com.gmail.lemonicplus.stonelavas.lava.fluid.lavas;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

import java.util.Optional;

public class AbstractLavaFluid extends FlowingFluid {
    @Override
    public Fluid getFlowing() {
        return null;
    }

    @Override
    public Fluid getSource() {
        return null;
    }

    @Override
    public Item getBucket() {
        return null;
    }

    public void animateTick(Level p_230567_, BlockPos p_230568_, FluidState p_230569_, RandomSource p_230570_) {
        BlockPos blockpos = p_230568_.above();
        if (p_230567_.getBlockState(blockpos).isAir() && !p_230567_.getBlockState(blockpos).isSolidRender(p_230567_, blockpos)) {
            if (p_230570_.nextInt(100) == 0) {
                double d0 = (double)p_230568_.getX() + p_230570_.nextDouble();
                double d1 = (double)p_230568_.getY() + 1.0D;
                double d2 = (double)p_230568_.getZ() + p_230570_.nextDouble();
                p_230567_.addParticle(ParticleTypes.LAVA, d0, d1, d2, 0.0D, 0.0D, 0.0D);
                p_230567_.playLocalSound(d0, d1, d2, SoundEvents.LAVA_POP, SoundSource.BLOCKS, 0.2F + p_230570_.nextFloat() * 0.2F, 0.9F + p_230570_.nextFloat() * 0.15F, false);
            }

            if (p_230570_.nextInt(200) == 0) {
                p_230567_.playLocalSound((double)p_230568_.getX(), (double)p_230568_.getY(), (double)p_230568_.getZ(), SoundEvents.LAVA_AMBIENT, SoundSource.BLOCKS, 0.2F + p_230570_.nextFloat() * 0.2F, 0.9F + p_230570_.nextFloat() * 0.15F, false);
            }
        }

    }

    public void randomTick(Level p_230572_, BlockPos p_230573_, FluidState p_230574_, RandomSource p_230575_) {
        if (p_230572_.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
            int i = p_230575_.nextInt(3);
            if (i > 0) {
                BlockPos blockpos = p_230573_;

                for(int j = 0; j < i; ++j) {
                    blockpos = blockpos.offset(p_230575_.nextInt(3) - 1, 1, p_230575_.nextInt(3) - 1);
                    if (!p_230572_.isLoaded(blockpos)) {
                        return;
                    }

                    BlockState blockstate = p_230572_.getBlockState(blockpos);
                    if (blockstate.isAir()) {
                        if (this.hasFlammableNeighbours(p_230572_, blockpos)) {
                            p_230572_.setBlockAndUpdate(blockpos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(p_230572_, blockpos, p_230573_, Blocks.FIRE.defaultBlockState()));
                            return;
                        }
                    } else if (blockstate.blocksMotion()) {
                        return;
                    }
                }
            } else {
                for(int k = 0; k < 3; ++k) {
                    BlockPos blockpos1 = p_230573_.offset(p_230575_.nextInt(3) - 1, 0, p_230575_.nextInt(3) - 1);
                    if (!p_230572_.isLoaded(blockpos1)) {
                        return;
                    }

                    if (p_230572_.isEmptyBlock(blockpos1.above()) && this.isFlammable(p_230572_, blockpos1, Direction.UP)) {
                        p_230572_.setBlockAndUpdate(blockpos1.above(), net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(p_230572_, blockpos1.above(), p_230573_, Blocks.FIRE.defaultBlockState()));
                    }
                }
            }

        }
    }
    private boolean hasFlammableNeighbours(LevelReader p_76228_, BlockPos p_76229_) {
        for(Direction direction : Direction.values()) {
            if (this.isFlammable(p_76228_, p_76229_.relative(direction), direction.getOpposite())) {
                return true;
            }
        }

        return false;
    }
    private boolean isFlammable(LevelReader level, BlockPos pos, Direction face) {
        return pos.getY() >= level.getMinBuildHeight() && pos.getY() < level.getMaxBuildHeight() && !level.hasChunkAt(pos) ? false : level.getBlockState(pos).isFlammable(level, pos, face);
    }
    public ParticleOptions getDripParticle() {
        return ParticleTypes.DRIPPING_LAVA;
    }

    @Override
    protected boolean canConvertToSource(Level level) {
        return level.getGameRules().getBoolean(GameRules.RULE_LAVA_SOURCE_CONVERSION);
    }

    @Override
    protected void beforeDestroyingBlock(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState) {
        this.fizz(levelAccessor, blockPos);
    }

    @Override
    protected int getSlopeFindDistance(LevelReader levelReader) {
        return levelReader.dimensionType().ultraWarm() ? 4 : 2;
    }

    @Override
    protected int getDropOff(LevelReader levelReader) {
        return levelReader.dimensionType().ultraWarm() ? 1 : 2;
    }

    @Override
    public boolean canBeReplacedWith(FluidState fluidState, BlockGetter blockGetter, BlockPos blockPos, Fluid fluid, Direction direction) {
        return fluidState.getHeight(blockGetter, blockPos) >= 0.44444445F && fluid.is(FluidTags.WATER);
    }

    @Override
    public int getTickDelay(LevelReader levelReader) {
        return levelReader.dimensionType().ultraWarm() ? 10 : 30;
    }

    public int getSpreadDelay(Level level, BlockPos blockPos, FluidState fluidState, FluidState fluidState1) {
        int i = this.getTickDelay(level);
        if (!fluidState.isEmpty() && !fluidState1.isEmpty() && !fluidState.getValue(FALLING) && !fluidState1.getValue(FALLING) && fluidState1.getHeight(level, blockPos) > fluidState.getHeight(level, blockPos) && level.getRandom().nextInt(4) != 0) {
            i *= 4;
        }

        return i;
    }

    private void fizz(LevelAccessor levelAccessor, BlockPos blockPos) {
        levelAccessor.levelEvent(1501, blockPos, 0);
    }

    public Optional<SoundEvent> getPickupSound() {
        return Optional.of(SoundEvents.BUCKET_FILL_LAVA);
    }

    @Override
    protected float getExplosionResistance() {
        return 100;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState fluidState) {
        return null;
    }

    @Override
    public boolean isSource(FluidState fluidState) {
        return false;
    }

    @Override
    public int getAmount(FluidState fluidState) {
        return fluidState.getValue(LEVEL);
    }
}
