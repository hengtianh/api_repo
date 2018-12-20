package org.easy.develop.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.easy.develop.web.base.WebModelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebControllerAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebControllerAspect.class);

	@Pointcut("execution(* org.easy.develop.web.controller.*Controller.*(..))")
	public void controller() {
		
	}

	@Around("controller()")
	public Object doAroundAdvice(ProceedingJoinPoint joinPoint) {
		try {
			doLogBeforeController(joinPoint);
			return joinPoint.proceed();
		} catch (Throwable throwable) {
			// TODO: handle exception
			LOGGER.error("call controller: " + joinPoint.getSignature().getName() + " args: "
					+ parseParams(joinPoint.getArgs()) + "throws exception: " + throwable.getMessage());
			return new WebModelBuilder().buildFailedModel();
		}
	}

	private void doLogBeforeController(ProceedingJoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getName();
		Signature signature = joinPoint.getSignature();
		String controllerName = className + "." + signature.getName();
		Object[] args = joinPoint.getArgs();
		LOGGER.info("call controller: " + controllerName + " args: " + parseParams(args));
	}
	
	public String parseParams(Object[] params) {
		StringBuffer buf = new StringBuffer();
		for(Object param : params) {
			buf.append(param.getClass().getSimpleName().toString() + ":" + param.toString() + "\r\t");
		}
		return buf.toString();
	}
	
}
