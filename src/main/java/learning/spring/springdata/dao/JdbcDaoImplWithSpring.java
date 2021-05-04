package learning.spring.springdata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import learning.spring.springdata.model.Circle;

/*
 * step 1 : Load Drivers
   step 2 : get Connection object using driverManager.getConnection
   step 3 : get PrepareStatement
   step 4 : execute it
 */
@Component
public class JdbcDaoImplWithSpring  {

	//bytype it should work
	DataSource dataSource;
	
	
	JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//whenever spring calls setter injection,initailize jdbctemplates as well.
	//setter injection
	@Autowired
	@Qualifier(value="datasource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public Circle getCircleBasedOnID() throws SQLException {
		Circle circle = null;
		
		Connection connection = getDataSource().getConnection("root","password");
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
	
	//This method shows how it is easier to use JDBCtemplate class of spring,which take care of all boiler plate code.
	public int getCircleCount() {
		String sql = "Select count(*) from circle";
		java.util.List<Map<String, Object>> list =getJdbcTemplate().queryForList(sql);
		System.out.println(list);
		return 0;
		
	}
	
	//different datatyypes:example to return string
	//auto-cast to string 
	public String getCircleName(int circleId) {
		String sql = "Select name from circle where id=?";
		String name = getJdbcTemplate().queryForObject(sql, new Object[] {circleId}, String.class);
		System.out.println("for ID="+circleId+" circleName="+name);
		return name;
	}
	
	
	//autocast to custom model object:only single row 
	public Circle getSingleCircleObjectUsingID(int id) {
		String sql ="select * from circle where id=?";
		Circle circle= getJdbcTemplate().queryForObject(sql, new Object[] {id}, new RowMapperExample());
		System.out.println("circle = "+circle.toString());
		System.out.println();
		return circle;
	}
	
	//auto cast to custom model : for multiple rows
	public List<Circle> getMultipleCircleObject(){
		String sql ="select * from circle";
		List<Circle> circles = getJdbcTemplate().query(sql, new RowMapperExample());
		System.out.println("circles = "+circles.toString());
		return circles;
	}
	
	
	//used to cast ,resultset to custom object
	class RowMapperExample implements RowMapper<Circle>{

		//this ,ethod internally called by spring for each row i,e when it read each row
		//so it dont require while loop on resultset
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("rowmapper rownumber="+rowNum);
			Circle circle = new Circle();
			circle.setName(rs.getString("name"));
			
			return circle;
		}
		
	}
	
	
	//DML and DDL
	
	public int insertCircle(Circle circle) {
		String sql="INSERT INTO circle(name) VALUES(?)";
		
		return getJdbcTemplate().update(sql, new Object[] {circle.getName()});
	}
	

	public void createTriangleTable() {
		String sql = "CREATE TABLE TRIANGLE(ID INT AUTO_INCREMENT PRIMARY KEY,NAME VARCHAR(100))";
		 getJdbcTemplate().execute(sql);
	}
	
	
	
	//USING NAMEDParameter
	public int insertCircleUsingNameParameter(Circle circle) {
		String sql = "INSERT INTO CIRCLE(name) VALUES(:name)";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("name", circle.getName());
		return this.namedParameterJdbcTemplate.update(sql, paramMap);
	}
	
}
