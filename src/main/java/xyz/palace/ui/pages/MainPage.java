package xyz.palace.ui.pages;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import xyz.palace.Palace;
import xyz.palace.ui.Palette;
import xyz.palacecore.framework.ui.Border;
import xyz.palacecore.framework.ui.element.BodyElement;
import xyz.palacecore.framework.ui.element.Element;
import xyz.palacecore.framework.ui.element.TextElement;
import xyz.palacecore.framework.ui.element.utils.Alignment;
import xyz.palacecore.framework.ui.element.utils.Styling;
import xyz.palacecore.framework.ui.font.FontManager;
import xyz.palacecore.framework.ui.page.Page;

import java.awt.*;

public class MainPage extends Page {

    public MainPage() {
        super("Main");
    }

    public void init() {
        this.getElements().clear();

        int w = 350;
        int h = 200;
        int x = MinecraftClient.getInstance().currentScreen.width / 2 - w / 2;
        int y = MinecraftClient.getInstance().currentScreen.height / 2 - h / 2;

        this.getElements().add(new BodyElement(
                new Border(
                        x,
                        y,
                        w,
                        h
                ),
                Palette.background,
                4
        ));

        this.getElements().add(new TextElement(
                new Border(
                        x + 10,
                        y + 10,
                        30,
                        30
                ),
                "Hello, world!",
                Color.white,
                FontManager.getInstance().getNUNITO_REGULAR_18(),
                Styling.SMOOTH,
                Alignment.LEFT
        ));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.getElements().forEach(element -> {
            element.draw(matrices, mouseX, mouseY, delta);
        });
    }
}
