package xyz.palacecore.framework.mod;

import lombok.Getter;

@Getter
public enum PalaceModCategories {

    ALL("All", 0),
    GENERAL("General", 1),
    RENDER("Render", 2);

    String name;
    int priority;

    PalaceModCategories(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}
