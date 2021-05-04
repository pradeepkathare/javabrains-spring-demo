package learning.spring.springdata.drivers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import learning.spring.springdata.dao.JdbcDaoImplWithSpringDaoSupport;

/*
 * Simple JDBC Impl without Spring
 * 
 * o/p:
 * circle =Circle [name=circle]

 */
public class C_44_Dao_Appmain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-data-application-context-xmls/application-context.xml");
		JdbcDaoImplWithSpringDaoSupport jdbcDaoImplWithSpringDaoSupport=context.getBean("jdbcDaoImplWithSpringDaoSupport",JdbcDaoImplWithSpringDaoSupport.class);
		try {
			jdbcDaoImplWithSpringDaoSupport.getCircleCount();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
