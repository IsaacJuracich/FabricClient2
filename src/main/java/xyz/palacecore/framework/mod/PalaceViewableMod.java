package xyz.palacecore.framework.mod;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.util.math.MatrixStack;

@Getter
@Setter
public abstract class PalaceViewableMod extends PalaceMod {

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onUpdate() {

    }

    public abstract void render(MatrixStack matrices, int mouseX, int mouseY, float delta);

    public abstract void renderPreview(MatrixStack matrices, int mouseX, int mouseY, float delta);

    void renderText(MatrixStack matrices, String text, int maxW) {

    }
}
