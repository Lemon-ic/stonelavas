package com.gmail.lemonicplus.untitled;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.*;

public class StoneLavasFluids {
    public static final FlowingFluid FLOWING_GRANITE_LAVA = register("flowing_granite_lava", new LavaFluid.Flowing());
    public static final FlowingFluid GRANITE_LAVA = register("granite_lava", new LavaFluid.Source());
    public static final FlowingFluid FLOWING_DIORITE_LAVA = register("flowing_diorite_lava", new LavaFluid.Flowing());
    public static final FlowingFluid DIORITE_LAVA = register("diorite_lava", new LavaFluid.Source());
    public static final FlowingFluid FLOWING_ANDESITE_LAVA = register("flowing_andesite_lava", new LavaFluid.Flowing());
    public static final FlowingFluid ANDESITE_LAVA = register("andesite_lava", new LavaFluid.Source());
    public static final FlowingFluid FLOWING_CALCITE_LAVA = register("flowing_calcite_lava", new LavaFluid.Flowing());
    public static final FlowingFluid CALCITE_LAVA = register("calcite_lava", new LavaFluid.Source());
    public static final FlowingFluid FLOWING_TUFF_LAVA = register("flowing_tuff_lava", new LavaFluid.Flowing());
    public static final FlowingFluid TUFF_LAVA = register("tuff_lava", new LavaFluid.Source());

    private static <T extends Fluid> T register(String p_76198_, T p_76199_) {
        return Registry.register(BuiltInRegistries.FLUID, p_76198_, p_76199_);
    }
}
