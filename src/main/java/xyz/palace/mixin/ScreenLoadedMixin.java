package xyz.palace.mixin;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;

@Mixin(MinecraftClient.class)
public class ScreenLoadedMixin {

    @Inject(method = "setScreen",
            at = @At(value = "FIELD",
                    target = "Lnet/minecraft/client/MinecraftClient;currentScreen:Lnet/minecraft/client/gui/screen/Screen;",
                    opcode = Opcodes.PUTFIELD))
    private void onScreenOpen(Screen newScreen, CallbackInfo info) {
        if (newScreen == null) return;
        if (newScreen.getClass().getName().startsWith("io.github.kosmx.emotes")) {
            System.out.println("ScreenLoadedMixin: " + newScreen.getClass().getName());

        }
    }
}