package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Loan;

import lombok.extern.slf4j.Slf4j;

//@Aspect
@Component
@Slf4j         // lombok annotation for logging 
public class RecourceInterceptorAscpect {

	
	  @Pointcut("execution(  * com.example.demo.RestController .*.*(..))") 
	  public void loggingPointCut() { }
	  
	  
	  @Before("loggingPointCut()") // @Before means before advice 
	  public void before(JoinPoint joinPoint) {
	  
	  log.info("Before method invoked :: " + joinPoint.getSignature());
	  
	  }
	  
	  @After("loggingPointCut()") // @After means after advice 
	  public void  after(JoinPoint joinPoint) {
	  
	  log.info("After method invoked :: " + joinPoint.getSignature());
	  
	  }
}
	 