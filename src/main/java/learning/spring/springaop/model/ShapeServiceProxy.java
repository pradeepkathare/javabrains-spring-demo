package learning.spring.springaop.model;

import learning.spring.springaop.aspects.LoggingAspect;

public class ShapeServiceProxy extends ShapeService {

	//this how @before annotation is used .It calls loggingAdvice of LoggingAspect before method called
	@Override
	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}
}
