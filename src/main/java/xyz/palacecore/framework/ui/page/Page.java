package xyz.palacecore.framework.ui.page;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.util.math.MatrixStack;
import xyz.palacecore.framework.ui.PalaceUI;
import xyz.palacecore.framework.ui.element.Element;

import java.util.List;

@Getter
@Setter
public abstract class Page {

    String pageName;
    List<Element> elements = new ObjectArrayList<>();

    public Page(String pageName) {
        this.pageName = pageName;
    }

    public abstract void render(MatrixStack matrices, int mouseX, int mouseY, float delta);
}
