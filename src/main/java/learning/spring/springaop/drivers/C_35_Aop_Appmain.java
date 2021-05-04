package learning.spring.springaop.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import learning.spring.springaop.model.CustomFactoryService;
import learning.spring.springaop.model.ShapeService;
import learning.spring.springaop.model.TriangleLoggableAnotation;

public class C_35_Aop_Appmain {

	public static void main(String[] args) {

		/*ApplicationContext context = new ClassPathXmlApplicationContext(
				"aop-application-context-xmls/c-26-aop-application-context.xml");

		//TriangleLoggableAnotation triangleLoggableAnotation = context.getBean("triangle-loggable",TriangleLoggableAnotation.class);
		
		System.out.println("custom-annotation-example="+triangleLoggableAnotation.getName());
*/		
		
		
		CustomFactoryService factory = new CustomFactoryService();
		ShapeService service = (ShapeService) factory.getBean("shapeService");
		service.getCircle();
	}

}
