package learning.spring.springdata.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import learning.spring.springdata.dao.JdbcDaoImplWithSpring;
import learning.spring.springdata.model.Circle;

/*
 * Simple JDBC Impl with Spring DriverManagerDatasource
 * 
 * o/p:
 * circle =Circle [name=circle]

 */

public class C_38_Dao_Appmain {


	
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring-data-application-context-xmls/application-context.xml");
			JdbcDaoImplWithSpring jdbcDaoImplWithSpring=context.getBean("jdbcDaoImplWithSpring",JdbcDaoImplWithSpring.class);
			
			jdbcDaoImplWithSpring.getCircleBasedOnID();
			//using JDBC template
			jdbcDaoImplWithSpring.getCircleCount();
		
			jdbcDaoImplWithSpring.getCircleName(1);
			
			//DML and DDL
			jdbcDaoImplWithSpring.insertCircle(new Circle("fourth circle"));
			//jdbcDaoImplWithSpring.createTriangleTable();
			
			//using named parameter
			jdbcDaoImplWithSpring.insertCircleUsingNameParameter(new Circle("Named parameter circle"));
			
			jdbcDaoImplWithSpring.getSingleCircleObjectUsingID(1);
			jdbcDaoImplWithSpring.getMultipleCircleObject();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
}


