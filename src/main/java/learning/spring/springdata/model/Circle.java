package learning.spring.springdata.model;

public class Circle {

	private String name;

	public Circle() {
		// TODO Auto-generated constructor stub
	}
	
	public Circle(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Circle [name=" + name + "]";
	}
	
	
}
