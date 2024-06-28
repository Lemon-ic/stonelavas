package com.gmail.lemonicplus.stonelavas.lava.init;

import com.gmail.lemonicplus.stonelavas.lava.fluid.AbstractLavaLiquidBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.gmail.lemonicplus.stonelavas.StoneLavas.MODID;

public class StoneLavaBlocks {
    public static final DeferredRegister<Block> STONELAVA_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Block> STONELAVA_CREATE_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final RegistryObject<Block> ANDESITE_LAVA_BLOCK = register("andesite_lava", () -> new AbstractLavaLiquidBlock(StoneLavaFluids.ANDESITE_LAVA.get(), BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<Block> CALCITE_LAVA_BLOCK = register("calcite_lava", () -> new AbstractLavaLiquidBlock(StoneLavaFluids.CALCITE_LAVA.get(), BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<Block> DEEPSLATE_LAVA_BLOCK = register("deepslate_lava", () -> new AbstractLavaLiquidBlock(StoneLavaFluids.DEEPSLATE_LAVA.get(), BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<Block> DIORITE_LAVA_BLOCK = register("diorite_lava", () -> new AbstractLavaLiquidBlock(StoneLavaFluids.DIORITE_LAVA.get(), BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<Block> GRANITE_LAVA_BLOCK = register("granite_lava", () -> new AbstractLavaLiquidBlock(StoneLavaFluids.GRANITE_LAVA.get(), BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<Block> TUFF_LAVA_BLOCK = register("tuff_lava", () -> new AbstractLavaLiquidBlock(StoneLavaFluids.TUFF_LAVA.get(), BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<Block> ASURINE_LAVA_BLOCK = createRegister("asurine_lava", () -> new AbstractLavaLiquidBlock(StoneLavaFluids.ASURINE_LAVA.get(), BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<Block> CRIMSITE_LAVA_BLOCK = createRegister("crimsite_lava", () -> new AbstractLavaLiquidBlock(StoneLavaFluids.CRIMSITE_LAVA.get(), BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<Block> OCHRUM_LAVA_BLOCK = createRegister("ochrum_lava", () -> new AbstractLavaLiquidBlock(StoneLavaFluids.OCHRUM_LAVA.get(), BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<Block> VERIDIUM_LAVA_BLOCK = createRegister("veridium_lava", () -> new AbstractLavaLiquidBlock(StoneLavaFluids.VERIDIUM_LAVA.get(), BlockBehaviour.Properties.copy(Blocks.LAVA)));
    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        return STONELAVA_BLOCKS.register(name, block);
    }
    private static <T extends Block> RegistryObject<T> createRegister(String name, Supplier<T> block){
        return STONELAVA_CREATE_BLOCKS.register(name, block);
    }

    public static void register(IEventBus eventBus) {
        STONELAVA_BLOCKS.register(eventBus);
        if(ModList.get().isLoaded("create")) STONELAVA_CREATE_BLOCKS.register(eventBus);
    }

}
