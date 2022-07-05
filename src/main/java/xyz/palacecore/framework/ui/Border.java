package xyz.palacecore.framework.ui;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Border {

    int x, y, w, h;

    public Border(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int getBottom() {
        return y + h;
    }

    public int getRight() {
        return x + w;
    }

    public int getCenterX() {
        return x + w / 2;
    }

    public int getCenterY() {
        return y + h / 2;
    }
}
