package xyz.palacecore.framework.mod.props;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PalaceColor implements Serializable {

    boolean chroma;
    int color;

    public PalaceColor(boolean chroma, int color) {
        this.chroma = chroma;
        this.color = color;
    }
}
