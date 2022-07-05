package xyz.palace;

import lombok.Getter;
import lombok.Setter;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import org.lwjgl.glfw.GLFW;
import xyz.palace.ui.MainUI;
import xyz.palacecore.framework.event.EventManager;
import xyz.palacecore.framework.event.EventTarget;
import xyz.palacecore.framework.event.events.EventKeyPress;
import xyz.palacecore.framework.ui.font.FontManager;

import java.io.File;

@Getter
@Setter
public class Palace implements ModInitializer {

	private static Palace instance;

	public Palace() {
		instance = this;

		File palaceDir = new File(MinecraftClient.getInstance().runDirectory.getPath() + "/palace");
		if (!palaceDir.exists()) palaceDir.mkdirs();
	}

	String palaceDirectory = MinecraftClient.getInstance().runDirectory.getPath() + "/palace";
	FontManager fontManager;
	boolean isEmoteCraftLoaded = false;

	@Override
	public void onInitialize() {
		EventManager.INSTANCE.register(this);
		System.out.println(FabricLoader.getInstance().getAllMods().size() + " mods loaded");
		boolean isEmoteCraftLoaded =
				FabricLoader.getInstance().getAllMods().stream().anyMatch(mod -> mod.getMetadata().getName().contains("Emotecraft"));
		if (isEmoteCraftLoaded)
			this.isEmoteCraftLoaded = true;
		this.fontManager = new FontManager();
	}

	public static Palace getInstance() {
		return instance;
	}

	@EventTarget
	public void onKeybindEvent(EventKeyPress event) {
		if (event.getKey() == GLFW.GLFW_KEY_RIGHT_SHIFT) {
			MinecraftClient.getInstance().setScreen(new MainUI());
		}
	}
}
