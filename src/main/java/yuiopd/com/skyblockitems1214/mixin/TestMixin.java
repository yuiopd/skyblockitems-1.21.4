package yuiopd.com.skyblockitems1214.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class TestMixin {
    @Shadow
    @Final
    private static Logger LOGGER;

    @Inject(at = @At("HEAD"), method = "loadWorld")
    private void init(CallbackInfo info) {
        // This code is injected into the start of MinecraftServer.loadWorld()V
        LOGGER.info("test");
    }
}
