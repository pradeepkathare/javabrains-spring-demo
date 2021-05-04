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
class 19 : Annotations : Autowired and Qualifier

1 : Autowired annotations,is used to specify dependency injection of member-variable in class
suppose,if we don't inject dependency object for bean in xml.
instead,if we provide autowired annotation on setter method,then spring internally search for the dependency in xml and inject it .


When we specify autowire on setter method,it will search for dependent bean .Spring searches for dependency beans
 in following order:

1 : byType (i,e className) : if it finds one bean with same type in xml then it will inject that bean.
							In case,if it finds multiple beans of same type.Then spring will search it byName
							
2 : byName : whenever member-variable matches to bean name .then it will inject  byName.
In case,if we have multiple beans of same type and we don't have  member-variable of same name.Then we can tell spring 
which bean to be injected by beanID using qualifier annotations  

3 : Qualifier :  When we have multiple beans of same type and no beans defined in xml matches member-variable of class
(so bytype and byName wont work),then we should specify Qualifier annotation

<!-- it will add all beanpostprocessor classes of spring -->
<context:annotation-config></context:annotation-config>

 */
public class C_19_AutowiringExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("C_19_AutowiringExample");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"c-19-autowiring-annotation-application-context.xml");
		System.out.println("Initalized application context");
		
		University university_2 = (University) context.getBean("college");
		university_2.collegeDetails();
		
		((ClassPathXmlApplicationContext) context).close();
		System.out.println("closed");
	}

}
