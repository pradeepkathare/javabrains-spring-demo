package learning.spring.springaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * Aspect class
 * 
 *o/p: since aspect of 2 classes are enabled..so it will print both:to disable one of it remove @component tag from the class
 *
 *loggingSecondAdvice  before method execution
prints complete class with methodname=execution(void learning.spring.springaop.model.Triangle.setName(String))
A method with string args is called
loogingAdviceForArgs that search parameter name as name=dummt-name
loggingSecondAdvice  before method execution
prints complete class with methodname=execution(String learning.spring.springaop.model.Triangle.getName())
logging advice before method execution
loggingSecondAdvice  before method execution
dummt-name

Note :Uncomment,@component to work  aspects
 */
@Aspect
//@Component
public class C_30_LoggingAspect {

	//should print all methods called
	@Before("pointcutForTrianlgeMethods()")
	public void loggingAdvice(JoinPoint joinpoint) {
		System.out.println("prints complete class with methodname="+joinpoint.toString());
		//we can do more with joinpoint explore it
	}
	
	@Before("args(String)")
	public void loggingAdviceForargs() {
		System.out.println("A method with string args is called");
		
	}
	
	@Before("args(name)")
	public void loogingAdviceForArgs(String name) {
		System.out.println("loogingAdviceForArgs that search parameter name as name="+name);
		
	}
	
	@Pointcut("within(learning.spring.springaop.model.Triangle)")
	public void pointcutForTrianlgeMethods() {};
	
	
	
}
