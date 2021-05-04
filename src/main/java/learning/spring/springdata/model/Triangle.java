package learning.spring.springdata.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Triangle {

	@Id
	private int id;
	private String name;
	

	public Triangle() {
		// TODO Auto-generated constructor stub
	}
	
	public Triangle(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Circle [name=" + name + "]";
	}
	
	
}
