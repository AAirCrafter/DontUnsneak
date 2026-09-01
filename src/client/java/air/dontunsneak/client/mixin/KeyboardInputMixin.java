package air.dontunsneak.client.mixin;

import air.dontunsneak.client.SneakState;
import net.minecraft.client.input.Input;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.util.PlayerInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardInput.class)
public abstract class KeyboardInputMixin extends Input {
    @Inject(method = "tick", at = @At("TAIL"))
    private void air$afterTick(CallbackInfo ci) {
        if (SneakState.shouldKeepSneaking()) {
            PlayerInput c = this.playerInput;

            this.playerInput = new PlayerInput(c.forward(), c.backward(), c.left(), c.right(), c.jump(), true, c.sprint());
        }
    }
}