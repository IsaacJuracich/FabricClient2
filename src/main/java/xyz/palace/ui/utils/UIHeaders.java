package xyz.palace.ui.utils;

import lombok.Getter;
import lombok.Setter;
import xyz.palace.ui.pages.ModPage;
import xyz.palacecore.framework.ui.page.Page;

@Getter
public enum UIHeaders {

    MODS("Mods", new ModPage());

    String name;
    Page page;

    UIHeaders(String name, Page page) {
        this.name = name;
        this.page = page;
    }
}
