package com.example.demo.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import com.example.demo.entity.Loan;
import lombok.extern.slf4j.Slf4j;

//@Aspect
@Component
@Slf4j
public class RecourceInterceptorAscpect2 {

	
	  @AfterReturning(value="execution(  * com.example.demo.RestController .*.*(..))"
	  ,returning="loan")
	  
	  public void afterRet(JoinPoint joinPoint, Loan loan) {
	  
	  log.info("After Returning method invoked :: "+loan);
	  
	  }
	  
	  @AfterThrowing
	  (value="execution( * com.tcs.rest.resources .*.*(..))",throwing= "e") 
	  public void afterThrow(JoinPoint joinPoint, Exception e) {
	  
	  log.info("After method invoked :: "+e);
	  
	  }
	 
	  
	 
}