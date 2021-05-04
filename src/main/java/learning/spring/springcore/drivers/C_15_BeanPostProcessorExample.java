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

/* o/p:
C_15_BeanPostProcessorExample
postProcessBeforeInitialization beanName=student
postProcessAfterInitialization beanName=student
postProcessBeforeInitialization beanName=studentAddress
postProcessAfterInitialization beanName=studentAddress
postProcessBeforeInitialization beanName=collegeAddress
postProcessAfterInitialization beanName=collegeAddress

Constructor of CollegeBeanLifeCycle class --1
postProcessBeforeInitialization beanName=college--2BeanPostProcessor
used to initalizing after bean creations--3 initMethod
postProcessAfterInitialization beanName=college--4BeanPostProcessor

Student details={}Student [name=studentA, rollNo=1]
student Address={}Address [area=studentAddress, pincode=583201]
college Address={}Address [area=CommonBean-collegeAdress, pincode=583201]
closing
used to destroy/closing connections
closed

BeanPostProcessor is used for init kind of method to be called by all beans in Single place
BeanPostProcessor is called each time when bean is created



 */
public class C_15_BeanPostProcessorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("C_15_BeanPostProcessorExample");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"c-15-beanpostprocessor-application-context.xml");
		
		CollegeBeanLifeCycle college = (CollegeBeanLifeCycle) context.getBean("college");
		college.collegeDetails();
		System.out.println("closing");
		((ClassPathXmlApplicationContext) context).close();
		System.out.println("closed");
	}

}
