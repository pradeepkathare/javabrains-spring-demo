package learning.spring.springcore.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * uses same as C_07
 * 
 */

import learning.spring.springcore.beans.College;
import learning.spring.springcore.beans.Colleges;

/* o/p:
C_13_BeanDefinitionInheritanceExample
default constructor
default constructor
====child college constructed  including parent object====
Student details={}Student [name=student1, rollNo=1]
student Address={}Address [area=studentAddress, pincode=583201]
college Address={}Address [area=CommonBean-collegeAdress, pincode=583201]

=====Bean defination inheritance for collection list======
Student details={}Student [name=student1, rollNo=1]
Student details={}Student [name=student2, rollNo=2]
student Address={}Address [area=studentAddress, pincode=583201]
college Address={}Address [area=CommonBean-collegeAdress, pincode=583201]


 */
public class C_13_BeanDefinitionInheritanceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("C_13_BeanDefinitionInheritanceExample");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"c-13-bean-definition-inheritance-application-context.xml");
		
		System.out.println("====child college constructed  including parent object====");
		College college = (College) context.getBean("childCollege");
		college.collegeDetails();

		System.out.println();
		System.out.println("=====Bean defination inheritance for collection list======");
		Colleges colleges =(Colleges) context.getBean("childColleges");
		colleges.collegeDetails();
		
		((ClassPathXmlApplicationContext) context).close();
	}

}
