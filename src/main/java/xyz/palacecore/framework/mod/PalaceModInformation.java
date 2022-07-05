package xyz.palacecore.framework.mod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PalaceModInformation {
    String name();
    String description();
    PalaceModCategories modCategory();
}
