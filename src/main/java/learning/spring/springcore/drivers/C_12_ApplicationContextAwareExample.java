package learning.spring.springcore.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * uses same as C_07
 * 
 */

import learning.spring.springcore.beans.College;
import learning.spring.springcore.beans.College_ApplicationContextAwareExample;

/* o/p:
1 : https://java2blog.com/injecting-prototype-bean-singleton-bean-spring/

injecting prototype bean into singleton bean
see difference before  implementing application-context

 */
public class C_12_ApplicationContextAwareExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("C_12_ApplicationContextAwareExample");

		// all beans will be created while initialization of context in singleton scope
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"c-12-applicationContextAware-application-context.xml");

		System.out.println("=====before implementing application-context=========");
		College college1 = (College) context.getBean("college");
		College college2 = (College) context.getBean("college");

		System.out.println("Is college1 and college2 are singleton=" + college1.equals(college2));

		// returns same hashocode ,instead of different.
		// i,e we expected student object to be created new everytime and different
		// hashcodes for college1 and college2
		// to solve we should use application context
		System.out.println("college1.student=" + college1.getStudent().hashCode());
		System.out.println("college2.student=" + college2.getStudent().hashCode());

		// expected to be prototype ,but student object act as singleton
		System.out.println("is college1.student and college2.student are  prototype="
				+ !(college1.getStudent().equals(college2.getStudent())));

		System.out.println("=====before implementing application-context end=========");

		System.out.println("====After implementing application-context -aware Start==== ");

		College_ApplicationContextAwareExample college_ApplicationContextAwareExample1 = (College_ApplicationContextAwareExample) context
				.getBean("college_applicationContextAwareExample");
		College_ApplicationContextAwareExample college_ApplicationContextAwareExample2 = (College_ApplicationContextAwareExample) context
				.getBean("college_applicationContextAwareExample");

		// expected to have 2 different hashcodes
		System.out.println("college_ApplicationContextAwareExample1.student="
				+ college_ApplicationContextAwareExample1.getStudent().hashCode());

		System.out.println("college_ApplicationContextAwareExample2.student="
				+ college_ApplicationContextAwareExample2.getStudent().hashCode());
		
		// expected to be prototype ,after implementing applicationContextAware it will return student object as prototype
		System.out.println("is college_ApplicationContextAwareExample1.student and college_ApplicationContextAwareExample2.student are  prototype="
				+ !(college_ApplicationContextAwareExample1.getStudent().equals(college_ApplicationContextAwareExample2.getStudent())));

		System.out.println("====After implementing application-context-aware End==== ");
		
		((ClassPathXmlApplicationContext) context).close();

	}

}
