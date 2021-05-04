package learning.spring.springcore.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import learning.spring.springcore.beans.Car;

public class C_06_ConstructorInjectionExample {

	public static void main(String[] args) {
		System.out.println("C_06_ConstructorInjectionExample");
		ApplicationContext context = new ClassPathXmlApplicationContext("constructor-injection-application-context.xml");
		
		Car car_SingleParamterConstructorMatchesStringParamterByDefault = (Car) context.getBean("car_SingleParamterConstructorMatchesStringParamterByDefault");
		car_SingleParamterConstructorMatchesStringParamterByDefault.draw();
		
		Car car_SingleParamterIntegerConstructor = (Car) context.getBean("car_SingleParamterIntegerConstructor");
		car_SingleParamterIntegerConstructor.draw();
		
		//o/p:car of model=red and colour=sweden of colst=500000
		Car car_MultiParamterConstructorbyDefaultOrder = (Car) context.getBean("car_MultiParamterConstructorbyDefaultOrder");
		car_MultiParamterConstructorbyDefaultOrder.draw();
		
		//o/p:car of model=sweden and colour=red of colst=500000
		Car car_MultiParamterConstructorbyCustomOrder = (Car) context.getBean("car_MultiParamterConstructorbyCustomOrder");
		car_MultiParamterConstructorbyCustomOrder.draw();
		
		((ClassPathXmlApplicationContext) context).close();

		
	}
}

