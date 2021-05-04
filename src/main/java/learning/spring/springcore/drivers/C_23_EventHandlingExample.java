package learning.spring.springcore.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * uses same as C_07
After bean creation it called init method and pre-destroy method before closing connection
 * 
 */

import learning.spring.springcore.beans.University;

/*This class demonstrates, @Autowired and @Component and MessageSource
 * 
 *
 * C_23_EventHandlingExample
default constructor
default constructor
default constructor
Application event name=org.springframework.context.event.ContextRefreshedEvent[source=org.springframework.context.support.ClassPathXmlApplicationContext@5e9f23b4, started on Wed Apr 21 07:18:21 IST 2021]
Initalized application context
college details of College class
Student details={}Student [name=student1, rollNo=1]
student Address={}Address [area=studentAddress, pincode=583201]
college Address={}Address [area=CommonBean-collegeAdress, pincode=583201]
hello
dynamic message : (parameter 0, parametr1) end

Publish my custom event
Application event name=I am custom event
Application event name=org.springframework.context.event.ContextClosedEvent[source=org.springframework.context.support.ClassPathXmlApplicationContext@5e9f23b4, started on Wed Apr 21 07:18:21 IST 2021]
closed


 */
public class C_23_EventHandlingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("C_23_EventHandlingExample");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"c-22-messagesource-application-context.xml");
		System.out.println("Initalized application context");
		
		University university_2 = (University) context.getBean("collegePublishEvent");
		university_2.collegeDetails();
		
		((ClassPathXmlApplicationContext) context).close();
		System.out.println("closed");
	}

}
