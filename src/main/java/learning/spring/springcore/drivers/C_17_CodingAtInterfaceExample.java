package learning.spring.springcore.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * uses same as C_07
After bean creation it called init method and pre-destroy method before closing connection
 * 
 */

import learning.spring.springcore.beans.College;
import learning.spring.springcore.beans.CollegeBeanLifeCycle;
import learning.spring.springcore.beans.University;

/*This class demonstrates, coding at interface
 * 
 *  o/p:

C_17_CodingAtInterfaceExample

C_17_CodingAtInterfaceExample
Constructor of CollegeBeanLifeCycle class
used to initalizing after bean creations
paramater constructor
Initalized application context

collegeDetails of CollegeBeanLifeCycle
Student details={}Student [name=student1, rollNo=1]
student Address={}Address [area=studentAddress, pincode=583201]
college Address={}Address [area=CommonBean-collegeAdress, pincode=583201]

college details of College class
Student details={}Student [name=student1, rollNo=1]
student Address={}Address [area=studentAddress, pincode=583201]
college Address={}Address [area=CommonBean-collegeAdress, pincode=583201]

used to destroy/closing connections
closed


 */
public class C_17_CodingAtInterfaceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("C_17_CodingAtInterfaceExample");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"c-17-codingAtInterface-application-context.xml");
		System.out.println("Initalized application context");
		
		University university_1 = (University) context.getBean("college-bean-life-cycle");
		university_1.collegeDetails();
		
		University university_2 = (University) context.getBean("college");
		university_2.collegeDetails();
		
		((ClassPathXmlApplicationContext) context).close();
		System.out.println("closed");
	}

}
