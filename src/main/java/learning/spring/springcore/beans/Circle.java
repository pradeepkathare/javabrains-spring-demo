package learning.spring.springcore.beans;


public class Circle{
	
	String type;
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void draw() {
		System.out.println("Draw shape of type="+getType());
	}
}