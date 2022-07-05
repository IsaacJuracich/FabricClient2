package xyz.palacecore.framework.ui.element;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Matrix4f;
import xyz.palacecore.framework.ui.Border;
import xyz.palacecore.framework.ui.DrawUtils;

import java.awt.*;

@Getter
@Setter
public class BodyElement extends Element {

    Color color;
    int curve;

    public BodyElement(Border border, Color color, int curve) {
        super(border);
        this.color = color;
        this.curve = curve;
    }

    @Override
    public void draw(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        DrawUtils.drawShape(
                border,
                matrices,
                color,
                curve,
                true,
                0
        );
        //DrawUtils.drawRoundedRect(
        //        matrices,
        //        this.getBorder().getX(),
        //        this.getBorder().getY(),
        //        this.getBorder().getW() + this.getBorder().getX(),
        //        this.getBorder().getH() + this.getBorder().getY(),
        //        this.curve,
       //         this.color
        //);
    }
}
