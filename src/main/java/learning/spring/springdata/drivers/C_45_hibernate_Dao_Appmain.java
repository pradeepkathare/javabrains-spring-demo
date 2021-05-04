package learning.spring.springdata.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import learning.spring.springdata.dao.HibernateDaoImpl;

public class C_45_hibernate_Dao_Appmain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-data-application-context-xmls/application-context.xml");

		HibernateDaoImpl hibernateDaoImpl = context.getBean("hibernateDaoImpl",HibernateDaoImpl.class);

		try
		{
			hibernateDaoImpl.getCircleCount();
		}catch(
		DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

