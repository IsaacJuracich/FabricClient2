package xyz.palace.mixin;

import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.Keyboard;
import xyz.palacecore.framework.event.events.EventKeyPress;

@Mixin(Keyboard.class)
public abstract class KeyboardMixin {

    int key = 0;

    @Inject(method = "onKey", at = @At("HEAD"), cancellable = true)
    public void onKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo info) {
        if (key != GLFW.GLFW_KEY_UNKNOWN) {
            if (this.key == key) return;
            EventKeyPress event = new EventKeyPress(key, scancode, action);
            event.call();
            this.key = key;
            if (event.isCancelled()) info.cancel();
        }
    }
}