package air.dontunsneak.client.mixin;

import air.dontunsneak.client.SneakState;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntitySneakMixin {
    @Inject(method = "tickMovement", at = @At("TAIL"))
    private void air$afterTickMovement(CallbackInfo ci) {
        if (SneakState.shouldKeepSneaking()) {
            ClientPlayerEntity self = (ClientPlayerEntity) (Object) this;

            if (!self.isSneaking()) self.setSneaking(true);
        }
    }
}