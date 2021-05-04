package learning.spring.springaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*Note : use driver class C_30_AopAppmain.java
 * o/p:
 *  After loggingAdvice=execution(void learning.spring.springaop.model.Triangle.setName(String))
 After loggingAdvice=execution(String learning.spring.springaop.model.Triangle.getName())
 After loggingAdviceAfterReturning=dummt-name jointpoint=execution(String learning.spring.springaop.model.Triangle.getName())
dummt-name

Note : very imp,
 */
//@Component
@Aspect
public class C_31_LoggingAspect {

	@After("pointcutForCircle()")
	public void loggingAdvice(JoinPoint point) {
		System.out.println(" After loggingAdvice=" + point.toString());
	}

	@AfterReturning(pointcut = "pointcutForCircle()", returning = "name") // any exception before returning value ,then
																			// this advice wont be executed
	public void loggingAdviceAfterReturning(JoinPoint point, String name) {
		System.out.println(" After loggingAdviceAfterReturning=" + name + " jointpoint=" + point.toString());
	}

	// Will be executed after any exception
	@AfterThrowing(pointcut = "pointcutForCircle()",throwing="ex")
	public void loggingAdviceAfterThrowing(RuntimeException ex) {
		System.out.println(" After loggingAdviceAfterThrowing"+ex);
	}

	@Pointcut("within(learning.spring.springaop.model.Triangle)")
	public void pointcutForCircle() {
	}

}
