package com.crow.legendarystructures.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

public class MarkOfTheAncientsItem extends Item {
    public MarkOfTheAncientsItem(Properties properties) {
        super(properties);
    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.literal("A strange symbol pulses with ancient energy").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            return InteractionResult.SUCCESS;
        }
        Component message = Component.literal("The symbol reacts faintly...");
        player.displayClientMessage(message, true);

        return InteractionResult.SUCCESS;
    }
}
