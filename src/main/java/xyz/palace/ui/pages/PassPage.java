package xyz.palace.ui.pages;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import xyz.palacecore.framework.ui.Border;
import xyz.palacecore.framework.ui.element.BodyElement;
import xyz.palacecore.framework.ui.page.Page;

import java.awt.*;

public class PassPage extends Page {


    public PassPage() {
        super("Pass");
    }

    public void init() {
        this.getElements().clear();

        int w = 350;
        int h = 200;
        int x = MinecraftClient.getInstance().currentScreen.width / 2 - w / 2;
        int y = MinecraftClient.getInstance().currentScreen.height / 2 - h / 2;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {

    }
}
