package com.gmail.lemonicplus.stonelavas;

import com.gmail.lemonicplus.stonelavas.lava.fluid.StoneLavaFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.gmail.lemonicplus.stonelavas.StoneLavas.MODID;

public class StoneLavaBuckets {
    public static final DeferredRegister<Item> STONELAVA_BUCKETS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Item> GRANITE_LAVA_BUCKET = register("granite_lava_bucket", () -> new BucketItem(StoneLavaFluids.GRANITE_LAVA, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> DIORITE_LAVA_BUCKET = register("diorite_lava_bucket", () -> new BucketItem(StoneLavaFluids.DIORITE_LAVA, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> ANDESITE_LAVA_BUCKET = register("andesite_lava_bucket", () -> new BucketItem(StoneLavaFluids.ANDESITE_LAVA, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> DEEPSLATE_LAVA_BUCKET = register("deepslate_lava_bucket", () -> new BucketItem(StoneLavaFluids.DEEPSLATE_LAVA, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> CALCITE_LAVA_BUCKET = register("calcite_lava_bucket", () -> new BucketItem(StoneLavaFluids.CALCITE_LAVA, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> TUFF_LAVA_BUCKET = register("tuff_lava_bucket", () -> new BucketItem(StoneLavaFluids.TUFF_LAVA, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1)));

    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> Item) {
        return STONELAVA_BUCKETS.register(name, Item);
    }

    public static void register(IEventBus eventBus) {
        STONELAVA_BUCKETS.register(eventBus);
    }
}
