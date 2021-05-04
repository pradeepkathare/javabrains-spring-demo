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

/*This class demonstrates, 
 * 
 *  
 *  In this bean will skip student dependency,throws null pointer when using student reference in class 
To avoid this,we can perform check using @required annotation on setter method.
 when bean is created and it checks its dependencies and throw exception at beggning if it dont have any dependency injected
RequiredBeanPostProcessor,does those check : if we dont add this bean then it wont do check

C_17_CodingAtInterfaceExample
default constructor
default constructor
Initalized application context

college details of College class
Student details={}Student [name=student1, rollNo=1]
student Address={}Address [area=studentAddress, pincode=583201]
college Address={}Address [area=CommonBean-collegeAdress, pincode=583201]

 without required annotations enabled
college details of College class
Exception in thread "main" java.lang.NullPointerException
	at learning.spring.springcore.beans.College.collegeDetails(College.java:50)
	at learning.spring.springcore.C_18_RequiredAnnotationExample.main(C_18_RequiredAnnotationExample.java:40)


o/p 2 : with required annotations

Caused by: org.springframework.beans.factory.BeanInitializationException: Property 'student' is required for bean 'college-required-annotation'
	at org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor.postProcessPropertyValues(RequiredAnnotationBeanPostProcessor.java:158)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1400)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:592)
	... 11 more
 */
public class C_18_RequiredAnnotationExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("C_18_RequiredAnnotationExample");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"c-18-required-annotation-application-context.xml");
		System.out.println("Initalized application context");
		
		University university_1 = (University) context.getBean("college");
		university_1.collegeDetails();
		
		//throws null pointer,we dont add required annotation in college class
		University university_2 = (University) context.getBean("college-required-annotation");
		university_2.collegeDetails();
		
		((ClassPathXmlApplicationContext) context).close();
		System.out.println("closed");
	}

}
