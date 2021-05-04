package learning.spring.springaop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * Aspect class
 * 
 * o/p for:@Before("execution(*  *())") for all methods
logging advice before method execution
logging advice before method execution
triangle-name

o/p for :@Before("execution(public String  getName())") only for getName methods
logging advice before method execution
triangle-name

o/p for:@Before("execution(public String  learning.spring.springaop.model.Circle.getName())") only for getName methods of Circle
logging advice before method execution
triangle-name

o/p for :@Before("circleGetnamePointCut()")
loggingSecondAdvice  before method execution
logging advice before method execution
loggingSecondAdvice  before method execution
pointcutCircleGetNameAdvice
triangle-name

o/p :@Before("pointcutForAllCircleMethods() && pointcutForGetNameMethod()")
loggingSecondAdvice  before method execution
logging advice before method execution
loggingAdviceForCircleGetName
loggingSecondAdvice  before method execution
pointcutCircleGetNameAdvice
triangle-name
 */
@Aspect
//@Component
public class LoggingAspect {

	// this method will be called for before getName() of any class is executed.here
	// either triangle.getname or circle.getName
	@Before("execution(public String  getName())")
	public void loggingAdvice() {
		System.out.println("logging advice before method execution");
	}

	@Before("execution(*  get*())")
	public void loggingSecondAdvice() {
		System.out.println("loggingSecondAdvice  before method execution");
	}

	// examples shows,how to use pointcut as expressions
	@Before("circleGetnamePointCut()")
	public void pointcutCircleGetNameAdvice() {
		System.out.println("pointcutCircleGetNameAdvice");
	}

	//this advice wil be called only for circle class , getname method
	@Before("pointcutForAllCircleMethods() && pointcutForGetNameMethod()")
	public void loggingAdviceForCircleGetName() {
		System.out.println("loggingAdviceForCircleGetName");
	}
		
	
	// point-cuts : used to define expression : if expression used multiple constraints 
	// then use point-cuts

	
	@Pointcut("execution(public String  learning.spring.springaop.model.Circle.getName())")
	void circleGetnamePointCut() {
		// just dummy method .this point cut to be used by advices as shown above
	}

	//within takes class-name as expression :this poitcut applies for all methods in Circle
	@Pointcut("within(learning.spring.springaop.model.Circle)")
	void pointcutForAllCircleMethods() {}
	
	@Pointcut("execution(*  getName())")
	void pointcutForGetNameMethod() {}
	
	
	
	
}
