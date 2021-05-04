package learning.spring.springcore.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import learning.spring.springcore.beans.Colleges;

/*
 * This class explains how to create beans when it has collection list as dependency. 
 * we should just use property tag with subtag as list and ref attribute
 * Below College class has list of students and given bean show how to create bean
 */
public class C_09_InjectingCollectionsListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("injecting-collection-list-application-context.xml");
		Colleges colleges = (Colleges) context.getBean("colleges");
		colleges.collegeDetails();

		((ClassPathXmlApplicationContext) context).close();
	}

}

