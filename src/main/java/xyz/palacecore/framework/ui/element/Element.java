package xyz.palacecore.framework.ui.element;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.util.math.MatrixStack;
import xyz.palacecore.framework.ui.Border;

@Getter
@Setter
public abstract class Element {

    Border border;

    public Element(Border border) {
        this.border = border;
    }

    public abstract void draw(MatrixStack matrices, int mouseX, int mouseY, float delta);
}
