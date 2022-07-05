package xyz.palacecore.framework.ui.element;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.util.math.MatrixStack;
import xyz.palacecore.framework.ui.Border;
import xyz.palacecore.framework.ui.element.utils.Alignment;
import xyz.palacecore.framework.ui.element.utils.Styling;
import xyz.palacecore.framework.ui.font.NahrFont;

import java.awt.*;

@Getter
@Setter
public class TextElement extends Element {

    String text;
    Color color;
    NahrFont font;
    Alignment alignment;
    Styling styling;

    public TextElement(Border border, String text, Color color, NahrFont font, Styling styling, Alignment alignment) {
        super(border);
        this.text = text;
        this.color = color;
        this.font = font;
        this.alignment = alignment;
        this.styling = styling;
    }

    @Override
    public void draw(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        if (this.getAlignment() == Alignment.CENTER) {
        }
        if (this.getAlignment() == Alignment.LEFT) {
            this.getFont().drawString(
                    matrices,
                    this.getText(),
                    this.getBorder().getX() + 1,
                    this.getBorder().getY() + (this.getBorder().getH() - this.getFont().getStringHeight(this.getText())) / 2,
                    NahrFont.FontType.EMBOSS_TOP,
                    this.getColor().getRGB()
            );
        }
        if (this.getAlignment() == Alignment.RIGHT) {
        }
    }
}
