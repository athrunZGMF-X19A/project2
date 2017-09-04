package com.revature.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CrossLogging {
	private static final Logger log = Logger.getLogger(CrossLogging.class);
	private static final String allMethods = 
			"execution( * *(..) )";
	
	
	@Before( value=allMethods)
	public void logAllMethods(JoinPoint joinpoint){
		log.info(joinpoint.getTarget());
	}
	
	
}
