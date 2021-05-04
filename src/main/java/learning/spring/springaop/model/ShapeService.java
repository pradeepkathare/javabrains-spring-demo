package learning.spring.springaop.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShapeService {

	@Autowired
	Triangle triangle;
	@Autowired
	Circle circle;
	
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	public Circle getCircle() {
		System.out.println("Shape service getCircle()");
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	
	
}
