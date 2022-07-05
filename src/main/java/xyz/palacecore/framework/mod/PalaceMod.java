package xyz.palacecore.framework.mod;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

import java.util.HashMap;
import java.util.Map;

public abstract class PalaceMod {

    public static final Map<PalaceModCategories, Map<Class<?>, PalaceMod>> palaceMods = new Object2ObjectOpenHashMap<>();

    public abstract void onEnable();

    public abstract void onDisable();

    public abstract void onUpdate();
}
