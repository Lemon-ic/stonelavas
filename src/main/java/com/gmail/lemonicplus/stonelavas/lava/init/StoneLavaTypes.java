package com.gmail.lemonicplus.stonelavas.lava.init;

import com.gmail.lemonicplus.stonelavas.StoneLavas;
import com.gmail.lemonicplus.stonelavas.lava.fluid.AbstractLavaType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class StoneLavaTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPE = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, StoneLavas.MODID);
    public static final DeferredRegister<FluidType> FLUID_CREATE_TYPE = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, StoneLavas.MODID);
    public static final RegistryObject<FluidType> ANDESITE_TYPE = FLUID_TYPE.register("andesite_type", AbstractLavaType::new);
    public static final RegistryObject<FluidType> CALCITE_TYPE = FLUID_TYPE.register("calcite_type", AbstractLavaType::new);
    public static final RegistryObject<FluidType> DEEPSLATE_TYPE = FLUID_TYPE.register("deepslate_type", AbstractLavaType::new);
    public static final RegistryObject<FluidType> DIORITE_TYPE = FLUID_TYPE.register("diorite_type", AbstractLavaType::new);
    public static final RegistryObject<FluidType> GRANITE_TYPE = FLUID_TYPE.register("granite_type", AbstractLavaType::new);
    public static final RegistryObject<FluidType> TUFF_TYPE = FLUID_TYPE.register("tuff_type", AbstractLavaType::new);
    public static final RegistryObject<FluidType> ASURINE_TYPE = FLUID_CREATE_TYPE.register("asurine_type", AbstractLavaType::new);
    public static final RegistryObject<FluidType> CRIMSITE_TYPE = FLUID_CREATE_TYPE.register("crimsite_type", AbstractLavaType::new);
    public static final RegistryObject<FluidType> OCHRUM_TYPE = FLUID_CREATE_TYPE.register("ochrum_type", AbstractLavaType::new);
    public static final RegistryObject<FluidType> VERIDIUM_TYPE = FLUID_CREATE_TYPE.register("veridium_type", AbstractLavaType::new);

    public static void register(IEventBus eventBus){
        FLUID_TYPE.register(eventBus);
        if(ModList.get().isLoaded("create")) FLUID_CREATE_TYPE.register(eventBus);
    }

}
