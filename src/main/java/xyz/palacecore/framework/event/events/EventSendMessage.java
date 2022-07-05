package xyz.palacecore.framework.event.events;
import xyz.palacecore.framework.event.Event;

public class EventSendMessage extends Event {

	private String message;
	
	public EventSendMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
