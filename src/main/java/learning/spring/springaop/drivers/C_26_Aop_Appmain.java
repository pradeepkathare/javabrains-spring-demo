package learning.spring.springaop.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import learning.spring.springaop.model.ShapeService;

public class C_26_Aop_Appmain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"aop-application-context-xmls/c-26-aop-application-context.xml");

		ShapeService shapeService = context.getBean("shapeService",ShapeService.class);
		
		System.out.println(""+shapeService.getCircle().getName());
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
