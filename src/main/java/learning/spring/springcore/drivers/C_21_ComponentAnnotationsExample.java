package learning.spring.springcore.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * uses same as C_07
After bean creation it called init method and pre-destroy method before closing connection
 * 
 */

import learning.spring.springcore.beans.University;

/*This class demonstrates, @Autowired and @Component but still beans are created in xml
 * 
 * o/p:
 * C_21_ComponentAnnotationsExample
default constructor
Initalized application context
college details of College class
Student details={}Student [name=student1, rollNo=1]
student Address={}Address [area=studentAddress, pincode=583201]
college Address={}Address [area=CommonBean-collegeAdress, pincode=583201]
closed
 * 
 */
public class C_21_ComponentAnnotationsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("C_21_ComponentAnnotationsExample");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"c-21-component-annotation-application-context.xml");
		System.out.println("Initalized application context");
		
		University university_2 = (University) context.getBean("collegeComponentAnnotation");
		university_2.collegeDetails();
		
		((ClassPathXmlApplicationContext) context).close();
		System.out.println("closed");
	}

}
