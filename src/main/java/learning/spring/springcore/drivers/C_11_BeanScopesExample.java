package learning.spring.springcore.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * uses same as C_07
 * 
 */

import learning.spring.springcore.beans.College;

/* o/p:
SingleTon is default scope of spring
college1= learning.spring.springcore.beans.College@5649fd9b
college2=learning.spring.springcore.beans.College@5649fd9b
is SingletonScope=true
application-context in spring is container
Here context and context1 are 2 containers
 */
public class C_11_BeanScopesExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("C_11_BeanScopesExample");
		
		//all beans will be created while initialization of context in singleton scope
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"c-11-bean-scope-application-context.xml");
		
		//In prototype,new bean will be created when u call getBean method
		College college1 = (College) context.getBean("college");
		College college2 = (College) context.getBean("college");
		
		System.out.println("college1= "+college1);
		System.out.println("college2="+college2);
		//when scope=singleton it will return true 
		System.out.println("is SingletonScope="+college1.equals(college2));

		//By default SingleTon scope, singleton per container
		//In Singleton ,new beans will be created when u create container.
		//so here,we have 2 containers and it will create 2 objects for single bean
		ApplicationContext context1 = new ClassPathXmlApplicationContext(
				"c-11-bean-scope-application-context.xml");
		
		
		College college3 = (College) context1.getBean("college");
		System.out.println("college3="+college3);
		//Is Singleton on different container=false
		System.out.println("Is Singleton on different container="+college1.equals(college3));
		
		((ClassPathXmlApplicationContext) context).close();
		((ClassPathXmlApplicationContext) context1).close();
	}

}
