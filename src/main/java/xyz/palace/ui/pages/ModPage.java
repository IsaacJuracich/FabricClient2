package xyz.palace.ui.pages;

import net.minecraft.client.util.math.MatrixStack;
import xyz.palacecore.framework.ui.element.Element;
import xyz.palacecore.framework.ui.page.Page;

import java.util.List;

public class ModPage extends Page {

    public ModPage() {
        super("Mods");
    }

    public void init() {
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.getElements().forEach(element -> element.draw(matrices, mouseX, mouseY, delta));
    }
}
