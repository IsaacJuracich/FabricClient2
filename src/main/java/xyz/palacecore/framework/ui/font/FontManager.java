package xyz.palacecore.framework.ui.font;

import lombok.Getter;
import lombok.Setter;

import java.io.InputStream;

@Getter
@Setter
public class FontManager {

    private static FontManager instance;

    public static FontManager getInstance() {
        return instance;
    }

    NahrFont NUNITO_REGULAR_12 = new NahrFont(
            this.getFileFromJar(this.getClass().getClassLoader(), "assets/palace/ui/fonts/Nunito-Regular.ttf"),
            12,
            1,
            false
    );
    NahrFont NUNITO_REGULAR_14 = new NahrFont(
            this.getFileFromJar(this.getClass().getClassLoader(), "assets/palace/ui/fonts/Nunito-Regular.ttf"),
            14,
            1,
            false
    );
    NahrFont NUNITO_REGULAR_16 = new NahrFont(
            this.getFileFromJar(this.getClass().getClassLoader(), "assets/palace/ui/fonts/Nunito-Regular.ttf"),
            16,
            1,
            false
    );
    NahrFont NUNITO_REGULAR_18 = new NahrFont(
            this.getFileFromJar(this.getClass().getClassLoader(), "assets/palace/ui/fonts/Nunito-Regular.ttf"),
            18,
            1,
            false
    );

    public FontManager() {
        instance = this;
    }

    public InputStream getFileFromJar(ClassLoader classLoader, String path) {
        return classLoader.getResourceAsStream(path);
    }
}