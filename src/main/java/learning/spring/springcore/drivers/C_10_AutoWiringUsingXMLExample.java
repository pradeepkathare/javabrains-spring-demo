package learning.spring.springcore.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * uses same as C_07
 * 
 */

import learning.spring.springcore.beans.College;

/* o/p:
injecting-dependency-using-autowiring-application-context.xml
1 : Injecting dependency automatically by spring.Internally it search dependency and resolve it.
2 : Autowiring can be performed by 3 ways :
    a) byName 
	b) byType : it will resolve dependency by matching type of bean in class
	problem : If we have multiple fields of same type in class ,then it doesn't resolve beans and through  NoUniqueBeanDefinitionException
	c) byConstructor : same as byType
	
3 : It is recommended,to explicitly define beans in property instead of using auto-wiring tag

 */
public class C_10_AutoWiringUsingXMLExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("C_10_AutoWiringUsingXMLExample");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"injecting-dependency-using-autowiring-application-context.xml");
		
		College college = (College) context.getBean("college");
		college.collegeDetails();

		((ClassPathXmlApplicationContext) context).close();
	}

}
