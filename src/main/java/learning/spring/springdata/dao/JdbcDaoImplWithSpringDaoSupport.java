package learning.spring.springdata.dao;

import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

/*
 * JdbcDaoSupport class support initializtion of jdbc template
 */
 //check xml 
public class JdbcDaoImplWithSpringDaoSupport extends JdbcDaoSupport {
	
	//This method shows how it is easier to use JDBCtemplate class of spring,which take care of all boiler plate code.
		public int getCircleCount() {
			System.out.println(" using JdbcDaoImplWithSpringDaoSupport");
			String sql = "Select count(*) from circle";
			java.util.List<Map<String, Object>> list =getJdbcTemplate().queryForList(sql);
			System.out.println(list);
			return 0;
			
		}

}
