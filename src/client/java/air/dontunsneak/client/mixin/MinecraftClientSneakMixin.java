package air.dontunsneak.client.mixin;

import air.dontunsneak.client.SneakState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientSneakMixin {
    @Inject(method = "setScreen", at = @At("HEAD"))
    private void air$onSetScreen(Screen screen, CallbackInfo ci) {
        MinecraftClient client = (MinecraftClient) (Object) this;

        if (screen != null) {
            boolean sneaking = client.options != null && client.options.sneakKey.isPressed();
            SneakState.onScreenOpening(sneaking);
        } else {
            SneakState.onScreenClosed();
        }
    }
}