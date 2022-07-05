package xyz.palacecore.framework.mod.props;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PalaceSlider implements Serializable {

    float min, max, value;
    String prefix;

    public PalaceSlider(float min, float max, float value, String prefix) {
        this.min = min;
        this.max = max;
        this.value = value;
        this.prefix = prefix;
    }
}
