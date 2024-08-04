package com.library.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(* com.library.service.*.*(..))")
	public void beforeExecution() {
		System.out.println("Logging before execution");
	}
	@After("execution(* com.library.service.*.*(..))")
	public void afterExecution() {
		System.out.println("Logging after execution");
	}
}
