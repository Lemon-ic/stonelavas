package com.gmail.lemonicplus.stonelavas.lava.init;

import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.gmail.lemonicplus.stonelavas.lava.fluid.lavas.*;
import com.simibubi.create.AllPackets;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.*;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidInteractionRegistry;
import net.minecraftforge.fluids.FluidInteractionRegistry.InteractionInformation;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.gmail.lemonicplus.stonelavas.StoneLavas.MODID;

public class StoneLavaFluids {


    public static final DeferredRegister<Fluid> STONELAVA_FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MODID);
    public static final DeferredRegister<Fluid> STONELAVA_CREATE_FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MODID);
    public static final RegistryObject<FlowingFluid> ANDESITE_LAVA = STONELAVA_FLUIDS.register("andesite_lava", AndesiteLavaFluid.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWING_ANDESITE_LAVA = STONELAVA_FLUIDS.register("flowing_andesite_lava", AndesiteLavaFluid.Flowing::new);
    public static final RegistryObject<FlowingFluid> CALCITE_LAVA = STONELAVA_FLUIDS.register("calcite_lava", CalciteLavaFluid.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWING_CALCITE_LAVA = STONELAVA_FLUIDS.register("flowing_calcite_lava", CalciteLavaFluid.Flowing::new);
    public static final RegistryObject<FlowingFluid> DIORITE_LAVA = STONELAVA_FLUIDS.register("diorite_lava", DioriteLavaFluid.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWING_DIORITE_LAVA = STONELAVA_FLUIDS.register("flowing_diorite_lava", DioriteLavaFluid.Flowing::new);
    public static final RegistryObject<FlowingFluid> DEEPSLATE_LAVA = STONELAVA_FLUIDS.register("deepslate_lava", DeepslateLavaFluid.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWING_DEEPSLATE_LAVA = STONELAVA_FLUIDS.register("flowing_deepslate_lava", DeepslateLavaFluid.Flowing::new);
    public static final RegistryObject<FlowingFluid> GRANITE_LAVA = STONELAVA_FLUIDS.register("granite_lava", GraniteLavaFluid.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWING_GRANITE_LAVA = STONELAVA_FLUIDS.register("flowing_granite_lava", GraniteLavaFluid.Flowing::new);
    public static final RegistryObject<FlowingFluid> TUFF_LAVA = STONELAVA_FLUIDS.register("tuff_lava", TuffLavaFluid.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWING_TUFF_LAVA = STONELAVA_FLUIDS.register("flowing_tuff_lava", TuffLavaFluid.Flowing::new);
    public static final RegistryObject<FlowingFluid> ASURINE_LAVA = STONELAVA_CREATE_FLUIDS.register("asurine_lava", AsurineLavaFluid.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWING_ASURINE_LAVA = STONELAVA_CREATE_FLUIDS.register("flowing_asurine_lava", AsurineLavaFluid.Flowing::new);
    public static final RegistryObject<FlowingFluid> CRIMSITE_LAVA = STONELAVA_CREATE_FLUIDS.register("crimsite_lava", CrimsiteLavaFluid.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWING_CRIMSITE_LAVA = STONELAVA_CREATE_FLUIDS.register("flowing_crimsite_lava", CrimsiteLavaFluid.Flowing::new);
    public static final RegistryObject<FlowingFluid> OCHRUM_LAVA = STONELAVA_CREATE_FLUIDS.register("ochrum_lava", OchrumLavaFluid.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWING_OCHRUM_LAVA = STONELAVA_CREATE_FLUIDS.register("flowing_ochrum_lava", OchrumLavaFluid.Flowing::new);
    public static final RegistryObject<FlowingFluid> VERIDIUM_LAVA = STONELAVA_CREATE_FLUIDS.register("veridium_lava", VeridiumLavaFluid.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWING_VERIDIUM_LAVA = STONELAVA_CREATE_FLUIDS.register("flowing_veridium_lava", VeridiumLavaFluid.Flowing::new);

    public static void register(IEventBus eventBus) {
        STONELAVA_FLUIDS.register(eventBus);
        if(ModList.get().isLoaded("create")) STONELAVA_CREATE_FLUIDS.register(eventBus);
    }

    public static void registerInteractions(){
        FluidInteractionRegistry.addInteraction(ANDESITE_LAVA.get().getFluidType(), new InteractionInformation(
                ForgeMod.WATER_TYPE.get(),
                fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : Blocks.ANDESITE.defaultBlockState()
        ));
        FluidInteractionRegistry.addInteraction(CALCITE_LAVA.get().getFluidType(), new InteractionInformation(
                ForgeMod.WATER_TYPE.get(),
                fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : Blocks.CALCITE.defaultBlockState()
        ));
        FluidInteractionRegistry.addInteraction(DEEPSLATE_LAVA.get().getFluidType(), new InteractionInformation(
                ForgeMod.WATER_TYPE.get(),
                fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : Blocks.DEEPSLATE.defaultBlockState()
        ));
        FluidInteractionRegistry.addInteraction(DIORITE_LAVA.get().getFluidType(), new InteractionInformation(
                ForgeMod.WATER_TYPE.get(),
                fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : Blocks.DIORITE.defaultBlockState()
        ));
        FluidInteractionRegistry.addInteraction(GRANITE_LAVA.get().getFluidType(), new InteractionInformation(
                ForgeMod.WATER_TYPE.get(),
                fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : Blocks.GRANITE.defaultBlockState()
        ));
        FluidInteractionRegistry.addInteraction(TUFF_LAVA.get().getFluidType(), new InteractionInformation(
                ForgeMod.WATER_TYPE.get(),
                fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : Blocks.TUFF.defaultBlockState()
        ));
        if(ModList.get().isLoaded("create")) {
            FluidInteractionRegistry.addInteraction(ASURINE_LAVA.get().getFluidType(), new InteractionInformation(
                    ForgeMod.WATER_TYPE.get(),
                    fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : AllPaletteStoneTypes.ASURINE.getBaseBlock().get().defaultBlockState()
            ));
            FluidInteractionRegistry.addInteraction(CRIMSITE_LAVA.get().getFluidType(), new InteractionInformation(
                    ForgeMod.WATER_TYPE.get(),
                    fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : AllPaletteStoneTypes.CRIMSITE.getBaseBlock().get().defaultBlockState()
            ));
            FluidInteractionRegistry.addInteraction(OCHRUM_LAVA.get().getFluidType(), new InteractionInformation(
                    ForgeMod.WATER_TYPE.get(),
                    fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : AllPaletteStoneTypes.OCHRUM.getBaseBlock().get().defaultBlockState()
            ));
            FluidInteractionRegistry.addInteraction(VERIDIUM_LAVA.get().getFluidType(), new InteractionInformation(
                    ForgeMod.WATER_TYPE.get(),
                    fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : AllPaletteStoneTypes.VERIDIUM.getBaseBlock().get().defaultBlockState()
            ));
        }
    }



}
