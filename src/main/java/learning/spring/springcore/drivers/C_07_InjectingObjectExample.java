package learning.spring.springcore.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import learning.spring.springcore.beans.College;

public class C_07_InjectingObjectExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("injecting-object-application-context.xml");
		College college = (College) context.getBean("college");
		college.collegeDetails();

		((ClassPathXmlApplicationContext) context).close();
	}

}


