package learning.spring.springcore.beans;


/*
 * when u have 2 constructor with same number of parameters,we should use type tag to define
 *  which constructor should be matched by spring or else by default spring matches with string
 */
public class Car{
	
	String model;
	String color;
	int cost;
	
	//Used as Constructor injection
	public Car(String model){
		this.model = model;
	}
	//when u set cost in xml,value will be string but internally it will cast
	public Car(int cost) {
		this.cost=cost;
	}
	
	public Car(String model,String color,int cost) {
		this.color=color;
		this.cost=cost;
		this.model = model;
		
	}
	public String getColor() {
		return color;
	}
	
	public String getModel() {
		return model;
	}
	
	public void draw() {
		System.out.println("car of model="+model+" and colour="+color+" of colst="+cost);
	}
}