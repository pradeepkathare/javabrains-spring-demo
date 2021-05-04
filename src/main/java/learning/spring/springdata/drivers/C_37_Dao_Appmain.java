package learning.spring.springdata.drivers;

import java.sql.SQLException;

import learning.spring.springdata.dao.JdbcDaoImplWithOutSpring;

/*
 * Simple JDBC Impl without Spring
 * 
 * o/p:
 * circle =Circle [name=circle]

 */
public class C_37_Dao_Appmain {

	public static void main(String[] args) {

		JdbcDaoImplWithOutSpring jstring = new JdbcDaoImplWithOutSpring();
		try {
			jstring.getCircleBasedOnID();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
