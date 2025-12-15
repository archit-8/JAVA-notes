package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Loan;

import lombok.extern.slf4j.Slf4j;

//@Aspect
@Component
@Slf4j
public class RecourceInterceptorAscpect3 {

	@Pointcut("execution(* com.example.demo.RestController.*.*(..))")
	public void loggingPointCut() {
	}

	@Around("loggingPointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

		log.info("Before method invoked :: " + joinPoint.getSignature());
		//log.info("Before method invoked :: " + joinPoint.getArgs()[0]);

		Object object = joinPoint.proceed();

		if (object instanceof Loan)
			log.info("After method invoked.... " + joinPoint.getSignature());
		log.info("After method invoked ::");

		//log.info("After method invoked :: " + joinPoint.getArgs()[0]);

		return object;

	}

}