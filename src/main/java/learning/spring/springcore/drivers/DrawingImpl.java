package learning.spring.springcore.drivers;

/*
 * Drawing class has dependency of Shape
 * Shape is injected outside the Drawing class i,e from different class
 * so this is what dependency injection:injecting shape object by other class
 */
class Drawing {

	Shape shape;

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	void draw() {
		this.shape.draw();
	}
}

interface Shape {

	void draw();
}

class Triangle implements Shape {

	public void draw() {
		System.out.println("Triangle draw method");
	}

}

/*
 * Here DrawingImpl, is the class the different class which is responsible for
 * forming dependency injection So spring provides different ways to inject
 * dependent object Here triangle object is injected to Drawing object
 */
public class DrawingImpl {

	public static void main(String[] args) {

		Drawing drawing = new Drawing();
		Triangle triangle = new Triangle();

		drawing.setShape(triangle);
		drawing.draw();
	}
}