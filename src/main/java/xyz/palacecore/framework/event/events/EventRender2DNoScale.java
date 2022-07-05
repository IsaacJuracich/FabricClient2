package xyz.palacecore.framework.event.events;
import xyz.palacecore.framework.event.Event;
import net.minecraft.client.util.math.MatrixStack;

public class EventRender2DNoScale extends Event {

	private MatrixStack matrices;
	private float tickDelta;
	
	public EventRender2DNoScale(MatrixStack matrices, float tickDelta) {
		this.matrices = matrices;
		this.tickDelta = tickDelta;
	}
	
	public MatrixStack getMatrices() {
		return matrices;
	}
	
	public float getTickDelta() {
		return tickDelta;
	}
}
