package webadv.example.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	@Pointcut("execution( * webadv.example.repository.TeacherRepository.*(..))")
	public void pointcut() {}
	
	@Before("pointcut()")
	public void log(JoinPoint jp){
		String methodName = jp.getSignature().getName();
		System.out.println("the method [" + methodName + "] begins with " + Arrays.asList(jp.getArgs()));
	}
		
}