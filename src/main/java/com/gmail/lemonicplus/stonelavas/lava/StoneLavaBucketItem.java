package com.gmail.lemonicplus.stonelavas.lava;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Nullable;

public class StoneLavaBucketItem extends BucketItem {
    private int burnTime = 20000;
    public StoneLavaBucketItem(Fluid fluid, Properties properties) {
        super(fluid, properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return burnTime;
    }
}
