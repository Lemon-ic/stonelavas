package com.gmail.lemonicplus.stonelavas.lava.init;

import com.gmail.lemonicplus.stonelavas.lava.StoneLavaBucketItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.gmail.lemonicplus.stonelavas.StoneLavas.MODID;

public class StoneLavaBuckets {
    public static final DeferredRegister<Item> STONELAVA_BUCKETS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<Item> STONELAVA_CREATE_BUCKETS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Item> ANDESITE_LAVA_BUCKET = register("andesite_lava_bucket", () -> new StoneLavaBucketItem(StoneLavaFluids.ANDESITE_LAVA.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> CALCITE_LAVA_BUCKET = register("calcite_lava_bucket", () -> new StoneLavaBucketItem(StoneLavaFluids.CALCITE_LAVA.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> DEEPSLATE_LAVA_BUCKET = register("deepslate_lava_bucket", () -> new StoneLavaBucketItem(StoneLavaFluids.DEEPSLATE_LAVA.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> DIORITE_LAVA_BUCKET = register("diorite_lava_bucket", () -> new StoneLavaBucketItem(StoneLavaFluids.DIORITE_LAVA.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> GRANITE_LAVA_BUCKET = register("granite_lava_bucket", () -> new StoneLavaBucketItem(StoneLavaFluids.GRANITE_LAVA.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> TUFF_LAVA_BUCKET = register("tuff_lava_bucket", () -> new StoneLavaBucketItem(StoneLavaFluids.TUFF_LAVA.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> ASURINE_LAVA_BUCKET = createRegister("asurine_lava_bucket", () -> new StoneLavaBucketItem(StoneLavaFluids.ASURINE_LAVA.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> CRIMSITE_LAVA_BUCKET = createRegister("crimsite_lava_bucket", () -> new StoneLavaBucketItem(StoneLavaFluids.CRIMSITE_LAVA.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> OCHRUM_LAVA_BUCKET = createRegister("ochrum_lava_bucket", () -> new StoneLavaBucketItem(StoneLavaFluids.OCHRUM_LAVA.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> VERIDIUM_LAVA_BUCKET = createRegister("veridium_lava_bucket", () -> new StoneLavaBucketItem(StoneLavaFluids.VERIDIUM_LAVA.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> Item) {
        return STONELAVA_BUCKETS.register(name, Item);
    }
    private static <T extends Item> RegistryObject<T> createRegister(String name, Supplier<T> Item) {
        return STONELAVA_CREATE_BUCKETS.register(name, Item);
    }

    public static void register(IEventBus eventBus) {
        STONELAVA_BUCKETS.register(eventBus);
        if(ModList.get().isLoaded("create")) STONELAVA_CREATE_BUCKETS.register(eventBus);
    }
}
