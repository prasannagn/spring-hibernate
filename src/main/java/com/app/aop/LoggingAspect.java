package com.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	public LoggingAspect() {
		System.out.println("LoggingAspect:..");
	}

	@Pointcut("execution(public * *(..))")
	public void log() {
	}

	@Before("log()")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("******");
		System.out.println("In : " + joinPoint.getSignature());
		for (Object arg : joinPoint.getArgs()) {
			System.out.println(arg);
		}

		System.out.println("******");
	}

	@After("log()")
	public void logAfter(JoinPoint joinPoint) {

		System.out.println("******");
		System.out.println("Out : " + joinPoint.getSignature());
		System.out.println("******");
	}

}