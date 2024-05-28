package com.gmail.lemonicplus.stonelavas.lava.fluid;

import com.gmail.lemonicplus.stonelavas.lava.fluid.lavas.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

import static com.gmail.lemonicplus.stonelavas.StoneLavas.MODID;

public class StoneLavaFluids {
    public static final DeferredRegister<Fluid> STONELAVA_FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MODID);
    public static final FlowingFluid FLOWING_GRANITE_LAVA = register("flowing_granite_lava", new GraniteLavaFluid.Flowing());
    public static final FlowingFluid GRANITE_LAVA = register("granite_lava", new GraniteLavaFluid.Source());
    public static final FlowingFluid FLOWING_DIORITE_LAVA = register("flowing_diorite_lava", new DioriteLavaFluid.Flowing());
    public static final FlowingFluid DIORITE_LAVA = register("diorite_lava", new DioriteLavaFluid.Source());
    public static final FlowingFluid FLOWING_ANDESITE_LAVA = register("flowing_andesite_lava", new AndesiteLavaFluid.Flowing());
    public static final FlowingFluid ANDESITE_LAVA = register("andesite_lava", new AndesiteLavaFluid.Source());
    public static final FlowingFluid FLOWING_DEEPSLATE_LAVA = register("flowing_deepslate_lava", new DeepslateLavaFluid.Flowing());
    public static final FlowingFluid DEEPSLATE_LAVA = register("deepslate_lava", new DeepslateLavaFluid.Source());
    public static final FlowingFluid FLOWING_CALCITE_LAVA = register("flowing_calcite_lava", new CalciteLavaFluid.Flowing());
    public static final FlowingFluid CALCITE_LAVA = register("calcite_lava", new CalciteLavaFluid.Source());
    public static final FlowingFluid FLOWING_TUFF_LAVA = register("flowing_tuff_lava", new TuffLavaFluid.Flowing());
    public static final FlowingFluid TUFF_LAVA = register("tuff_lava", new TuffLavaFluid.Source());

    private static <T extends Fluid> T register(String name, T fluid) {
        return STONELAVA_FLUIDS.register(name,fluid);
    }

    public static void register(IEventBus eventBus) {
        STONELAVA_FLUIDS.register(eventBus);
    }
}
