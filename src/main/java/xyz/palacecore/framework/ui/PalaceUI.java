package xyz.palacecore.framework.ui;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import xyz.palacecore.framework.ui.element.Element;
import xyz.palacecore.framework.ui.page.Page;

import java.util.List;

@Getter
@Setter
public class PalaceUI extends Screen {

    Page currentPage;
    double mX, mY;
    List<Element> elements = new ObjectArrayList<>();
    List<Page> pages = new ObjectArrayList<>();

    public PalaceUI() {
        super(Text.of("Palace UI"));
    }

    @Override
    public void init() {
        this.uiInit();
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderUI(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.onMouseClick(mouseX, mouseY, button);
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double amount) {
        this.onMouseScrolled(mouseX, mouseY, amount);
        return super.mouseScrolled(mouseX, mouseY, amount);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        this.onMouseDragged(mouseX, mouseY, button, deltaX, deltaY);
        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        this.onMouseReleased(mouseX, mouseY, button);
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public void mouseMoved(double mouseX, double mouseY) {
        this.onMouseMoved(mouseX, mouseY);
        this.setMX(mouseX);
        this.setMY(mouseY);
        super.mouseMoved(mouseX, mouseY);
    }

    public void uiInit() {}

    public void renderUI(MatrixStack matrices, int mouseX, int mouseY, float delta) {}

    public void onMouseClick(double mouseX, double mouseY, int button) {}

    public void onMouseScrolled(double mouseX, double mouseY, double amount) {}

    public void onMouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {}

    public void onMouseReleased(double mouseX, double mouseY, int button) {}

    public void onMouseMoved(double mouseX, double mouseY) {}
}
