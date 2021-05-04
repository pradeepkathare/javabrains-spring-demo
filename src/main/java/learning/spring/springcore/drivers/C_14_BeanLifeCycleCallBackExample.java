package learning.spring.springcore.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * uses same as C_07
After bean creation it called init method and pre-destroy method before closing connection
 * 
 */

import learning.spring.springcore.beans.CollegeBeanLifeCycle;

/* o/p:
C_14_BeanLifeCycleCallBackExample
used to initalizing after bean creations

Student details={}Student [name=studentA, rollNo=1]
student Address={}Address [area=studentAddress, pincode=583201]
college Address={}Address [area=CommonBean-collegeAdress, pincode=583201]

closing
used to destroy/closing connections
closed



 */
public class C_14_BeanLifeCycleCallBackExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("C_14_BeanDefinitionInheritanceExample");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"c-14-bean-lifecycle-application-context.xml");
		
		CollegeBeanLifeCycle college = (CollegeBeanLifeCycle) context.getBean("college");
		college.collegeDetails();
		System.out.println("closing");
		((ClassPathXmlApplicationContext) context).close();
		System.out.println("closed");
	}

}
