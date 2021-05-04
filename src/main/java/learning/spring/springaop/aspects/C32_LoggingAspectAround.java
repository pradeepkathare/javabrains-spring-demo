package learning.spring.springaop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * o/p:
 * ==
 * Before around advice=execution(void learning.spring.springaop.model.Triangle.setName(String))
after around advice=execution(void learning.spring.springaop.model.Triangle.setName(String))
Before around advice=execution(String learning.spring.springaop.model.Triangle.getName())
after around advice=execution(String learning.spring.springaop.model.Triangle.getName())
dummt-name

 */
@Aspect
//@Component
public class C32_LoggingAspectAround {

	@Around("pointcutForTriangle()")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		
		//if u dont return value,then all ur getter methods returns value will be overriden by  null
		//so to check,just comment null and check
		Object returnvalue=null;
		try {
			System.out.println("Before around advice="+proceedingJoinPoint.toString());
			returnvalue=proceedingJoinPoint.proceed();
			System.out.println("after around advice="+proceedingJoinPoint.toString());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return returnvalue;
	}
	
	@Pointcut("within(learning.spring.springaop.model.Triangle)")
	public void pointcutForTriangle(){}
}
