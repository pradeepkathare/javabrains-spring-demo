package learning.spring.springcore.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * uses same as C_07
After bean creation it called init method and pre-destroy method before closing connection
 * 
 */

import learning.spring.springcore.beans.University;

/*This class demonstrates, coding at interface
 * 
 *  o/p:
@resource
@postconstruct and predestroy

C_20_JSRAnnotationsExample
default constructor
CollegeJSRAnnotation init method
Initalized application context
college details of College class
Student details={}Student [name=student1, rollNo=1]
student Address={}Address [area=studentAddress, pincode=583201]
college Address={}Address [area=CommonBean-collegeAdress, pincode=583201]
CollegeJSRAnnotation init method
closed


 */
public class C_20_JSRAnnotationsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("C_20_JSRAnnotationsExample");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"c-20-jsr-annotation-application-context.xml");
		System.out.println("Initalized application context");
		
		University university_2 = (University) context.getBean("college");
		university_2.collegeDetails();
		
		((ClassPathXmlApplicationContext) context).close();
		System.out.println("closed");
	}

}
