package learning.spring.springaop.model;

public class CustomFactoryService {

/*
 * custom class of beanName()
 */
	public Object getBean(String beanName) {
		System.out.println("CustomFactoryService getBean");
		if(beanName.equalsIgnoreCase("shapeService")) return new ShapeServiceProxy(); //changed from ShapeService()
		if(beanName.equalsIgnoreCase("circle")) return new Circle();
		if(beanName.equalsIgnoreCase("triangle")) return new Triangle();
		
		return null;
	}
}
