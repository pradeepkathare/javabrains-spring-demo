package learning.spring.springcore.beans;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class C_23_ApplicationEventListener implements ApplicationListener<ApplicationEvent>{

	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("Application event name="+event.toString());
		
	}

}
