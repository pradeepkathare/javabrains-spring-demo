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
 * 
 */
public class C_22_MessageSourceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("C_23_EventHandlingExample");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"c-22-messagesource-application-context.xml");
		System.out.println("Initalized application context");
		
		University university_2 = (University) context.getBean("collegeMessageSource");
		university_2.collegeDetails();
		
		((ClassPathXmlApplicationContext) context).close();
		System.out.println("closed");
	}

}
