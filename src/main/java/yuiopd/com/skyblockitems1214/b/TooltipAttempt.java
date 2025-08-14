package yuiopd.com.skyblockitems1214.b;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class TooltipAttempt extends Item {

    public TooltipAttempt(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("itemTooltip.skyblockitems1214.aote").formatted(Formatting.GOLD));
    }
}
