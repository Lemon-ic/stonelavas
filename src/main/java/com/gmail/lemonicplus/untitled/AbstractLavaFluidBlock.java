package com.gmail.lemonicplus.untitled;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;

public class AbstractLavaFluidBlock extends LiquidBlock {
    public AbstractLavaFluidBlock(FlowingFluid flowingFluid, Properties properties) {
        super(flowingFluid, properties);
    }
}
