package com.gmail.lemonicplus.stonelavas;

import com.gmail.lemonicplus.stonelavas.lava.init.StoneLavaBlocks;
import com.gmail.lemonicplus.stonelavas.lava.init.StoneLavaBuckets;
import com.gmail.lemonicplus.stonelavas.lava.init.StoneLavaFluids;
import com.gmail.lemonicplus.stonelavas.lava.init.StoneLavaTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(StoneLavas.MODID)
public class StoneLavas {

    public static final String MODID = "stonelavas";


    public StoneLavas() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        StoneLavaBlocks.register(modEventBus);
        StoneLavaBuckets.register(modEventBus);
        StoneLavaTypes.register(modEventBus);
        StoneLavaFluids.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::init);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public void init(final FMLCommonSetupEvent event){
        StoneLavaFluids.registerInteractions();
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.accept(StoneLavaBuckets.ANDESITE_LAVA_BUCKET);
            event.accept(StoneLavaBuckets.CALCITE_LAVA_BUCKET);
            event.accept(StoneLavaBuckets.DEEPSLATE_LAVA_BUCKET);
            event.accept(StoneLavaBuckets.DIORITE_LAVA_BUCKET);
            event.accept(StoneLavaBuckets.GRANITE_LAVA_BUCKET);
            event.accept(StoneLavaBuckets.TUFF_LAVA_BUCKET);
            if(ModList.get().isLoaded("create")) {
                event.accept(StoneLavaBuckets.ASURINE_LAVA_BUCKET);
                event.accept(StoneLavaBuckets.CRIMSITE_LAVA_BUCKET);
                event.accept(StoneLavaBuckets.OCHRUM_LAVA_BUCKET);
                event.accept(StoneLavaBuckets.VERIDIUM_LAVA_BUCKET);
            }
        }
    }
}
