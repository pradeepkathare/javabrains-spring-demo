package learning.spring.springcore.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import learning.spring.springcore.beans.Circle;

/*
 * This class defines ApplicationContext:which is child i of BeanFactory with more advantages
 * ApplicationContext looks for xml in classpath i,e in src folder so create it there
 * in xml,we have defined id for circle with property value for type.
 * so Spring internally creating object ,and 
 * when we use property tag ,values for dependent fields are injected through its setter .hence setter injection
 * 
 */
public class C_05_ApplicationContextExample {

	public static void main(String[] args) {
		System.out.println("ApplicationContext example");
		ApplicationContext context = new  ClassPathXmlApplicationContext("application-context.xml");
		Circle circle = (Circle) context.getBean("circle");
		circle.draw();
	}

}


