package learning.spring.springcore.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * uses same as C_07
 * 
 */

import learning.spring.springcore.beans.College;

/* o/p:
 injecting-object-InnerBeans-application-context.xml
Student details={}Student [name=studentA, rollNo=1]
student Address={}Address [area=studentAddress, pincode=583201]
college Address={}Address [area=CommonBean-collegeAdress, pincode=583201]
 */
public class C_08_InjectingObjectUsingInnerBeanExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("injecting-object-InnerBeans-application-context.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"injecting-object-InnerBeans-application-context.xml");
		College college = (College) context.getBean("college");
		college.collegeDetails();

		College college_alias = (College) context.getBean("college-alias");
		college.collegeDetails();
		((ClassPathXmlApplicationContext) context).close();
	}

}
