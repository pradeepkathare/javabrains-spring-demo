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

C_16_BeanFactoryPostProcessorExample
postProcessBeanFactory called before creating all Beans --1

postProcessBeforeInitialization beanName=student
postProcessAfterInitialization beanName=student
postProcessBeforeInitialization beanName=studentAddress
postProcessAfterInitialization beanName=studentAddress
postProcessBeforeInitialization beanName=collegeAddress
postProcessAfterInitialization beanName=collegeAddress

Constructor of CollegeBeanLifeCycle class --2
postProcessBeforeInitialization beanName=college--3
used to initalizing after bean creations--4
postProcessAfterInitialization beanName=college--5
Initalized application context--6

Student details={}Student [name=studentA, rollNo=1]
student Address={}Address [area=studentAddress, pincode=583201]
college Address={}Address [area=CommonBean-collegeAdress, pincode=583201]

closing--6
used to destroy/closing connections--7
closed--8


 */
public class C_16_BeanFactoryPostProcessorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("C_16_BeanFactoryPostProcessorExample");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"c-16-bean-factorypostprocessor-application-context.xml");
		System.out.println("Initalized application context");
		CollegeBeanLifeCycle college = (CollegeBeanLifeCycle) context.getBean("college");
		college.collegeDetails();
		System.out.println("closing");
		((ClassPathXmlApplicationContext) context).close();
		System.out.println("closed");
	}

}
