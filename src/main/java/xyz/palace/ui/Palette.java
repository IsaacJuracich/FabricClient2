package xyz.palace.ui;

import java.awt.*;
import java.util.function.Supplier;

public class Palette {

    public static Color gradient_start;
    public static Color gradient_end;
    public static Color background;
    public static Color background_darker;
    public static Color white_dull;

    static {
        gradient_start = new Color(30, 140, 201);
        gradient_end = new Color(76, 187, 243);
        background = new Color(41, 44, 61, 200);
        background_darker = new Color(27, 30, 38, 245);
        white_dull = new Color(255, 255, 255, 100);
    }
}
