package me.marzeq.whyactionbar.mixin;
import me.marzeq.whyactionbar.WhyActionBar;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.text.Text;

@Mixin(InGameHud.class)
public class ActionBarMixin {

    @Inject(at = @At("HEAD"), method = "setOverlayMessage(Lnet/minecraft/text/Text;Z)V", cancellable = true)
    private void sendMessage(Text message, boolean tinted, CallbackInfo info) {
        if (message.getString().matches(WhyActionBar.regex)) {
            info.cancel();
        }
    }
}