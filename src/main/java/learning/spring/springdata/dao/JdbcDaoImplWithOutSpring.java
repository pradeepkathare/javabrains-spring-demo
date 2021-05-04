package learning.spring.springdata.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import learning.spring.springdata.model.Circle;

/*
 * step 1 : Load Drivers(it did it internally)
   step 2 : get Connection object using driverManager.getConnection
   step 3 : get PrepareStatement
   step 4 : execute it
 */

public class JdbcDaoImplWithOutSpring {

	
	public Circle getCircleBasedOnID() throws SQLException {
		Circle circle = null;
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","password");
		PreparedStatement preStatement = connection.prepareStatement("Select * from circle where id=?");
		preStatement.setInt(1, 1);
		ResultSet resultset = preStatement.executeQuery();
		while(resultset.next()) {
			 circle = new Circle();
			circle.setName(resultset.getString(2));
		}
		System.out.println("circle ="+circle.toString());
		return circle;
	}
}
