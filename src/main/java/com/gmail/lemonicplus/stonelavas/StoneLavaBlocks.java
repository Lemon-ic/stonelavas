package com.gmail.lemonicplus.stonelavas;

import com.gmail.lemonicplus.stonelavas.lava.fluid.AbstractLavaLiquidBlock;
import com.gmail.lemonicplus.stonelavas.lava.fluid.StoneLavaFluids;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.gmail.lemonicplus.stonelavas.StoneLavas.MODID;

public class StoneLavaBlocks {
    public static final DeferredRegister<Block> STONELAVA_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final RegistryObject<Block> GRANITE_LAVA = register("granite_lava", () -> new AbstractLavaLiquidBlock(StoneLavaFluids.GRANITE_LAVA, BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<Block> DIORITE_LAVA = register("diorite_lava", () -> new AbstractLavaLiquidBlock(StoneLavaFluids.DIORITE_LAVA, BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<Block> ANDESITE_LAVA = register("andesite_lava", () -> new AbstractLavaLiquidBlock(StoneLavaFluids.ANDESITE_LAVA, BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<Block> DEEPSLATE_LAVA = register("deepslate_lava", () -> new AbstractLavaLiquidBlock(StoneLavaFluids.DEEPSLATE_LAVA, BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<Block> CALCITE_LAVA = register("calcite_lava", () -> new AbstractLavaLiquidBlock(StoneLavaFluids.CALCITE_LAVA, BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<Block> TUFF_LAVA = register("tuff_lava", () -> new AbstractLavaLiquidBlock(StoneLavaFluids.TUFF_LAVA, BlockBehaviour.Properties.copy(Blocks.LAVA)));
    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        return STONELAVA_BLOCKS.register(name, block);
    }

    public static void register(IEventBus eventBus) {
        STONELAVA_BLOCKS.register(eventBus);
    }
}
