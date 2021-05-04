package learning.spring.springcore.beans;

import org.springframework.context.ApplicationEvent;

/*
 * This is custom event class
 */
public class C23_CustomEvent extends ApplicationEvent {

	public C23_CustomEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	
	public String toString() {
		return "I am custom event";
	}
}
