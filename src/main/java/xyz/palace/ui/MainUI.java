package xyz.palace.ui;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.util.math.MatrixStack;
import xyz.palace.ui.pages.MainPage;
import xyz.palace.ui.utils.UIHeaders;
import xyz.palacecore.framework.ui.PalaceUI;

@Getter
@Setter
public class MainUI extends PalaceUI {

    MainPage mainPage = new MainPage();
    UIHeaders currentHeader = UIHeaders.MODS;

    private static MainUI instance;

    public static MainUI getInstance() {
        return instance;
    }

    public MainUI() {
        instance = this;
    }

    @Override
    public void uiInit() {
        this.getMainPage().init();
    }

    @Override
    public void renderUI(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.getMainPage().render(matrices, mouseX, mouseY, delta);
        //this.getCurrentHeader().getPage().render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public void onMouseClick(double mouseX, double mouseY, int button) {

    }

    @Override
    public void onMouseScrolled(double mouseX, double mouseY, double amount) {

    }

    @Override
    public void onMouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {

    }

    @Override
    public void onMouseReleased(double mouseX, double mouseY, int button) {

    }

    @Override
    public void onMouseMoved(double mouseX, double mouseY) {

    }
}
