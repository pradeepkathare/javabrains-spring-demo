package learning.spring.springaop.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import learning.spring.springaop.model.ShapeService;

public class C_30_Aop_Appmain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"aop-application-context-xmls/c-26-aop-application-context.xml");

		ShapeService shapeService = context.getBean("shapeService",ShapeService.class);
		shapeService.getTriangle().setName("dummt-name");
		System.out.println(""+shapeService.getTriangle().getName());
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
