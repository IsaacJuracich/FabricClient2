package xyz.palacecore.framework.event.events;
import xyz.palacecore.framework.event.Event;
import net.minecraft.client.util.math.MatrixStack;

public class EventRenderGUI extends Event {

	private MatrixStack matrices;
	private float tickDelta;
	
	public EventRenderGUI(MatrixStack matrices, float tickDelta) {
		this.matrices = matrices;
		this.tickDelta = tickDelta;
	}
	
	protected EventRenderGUI() {}

	public MatrixStack getMatrices() {
		return matrices;
	}
	
	public float getTickDelta() {
		return tickDelta;
	}
	
	public static class Tick extends EventRenderGUI {
		
	}
}
