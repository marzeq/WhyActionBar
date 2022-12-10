package me.marzeq.whyactionbar;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class WhyActionBar implements ModInitializer {
    @Override
    public void onInitialize() {}

    public static String regex = ".*Ping: \\d+ms.*";

    public static void chat(String message) {
        MinecraftClient c = MinecraftClient.getInstance();
        if (c == null) {
            return;
        }
        c.inGameHud.getChatHud().addMessage(Text.of(message));
    }
}
