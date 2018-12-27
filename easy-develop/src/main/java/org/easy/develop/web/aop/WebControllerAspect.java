package org.easy.develop.web.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebControllerAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebControllerAspect.class);
	
	private static final String METHOD_NAME = "name";
	
	private static final String METHOD_ARGS = "args";

	@Pointcut("execution(* org.easy.develop.web.controller.*Controller.*(..))")
	public void controller() {
		
	}

	@Around("controller()")
	public Object doAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		Map<String, String> methodInfoMap = getMethodInfo(joinPoint);
		try {
			doLogBeforeController(methodInfoMap);
			return joinPoint.proceed();
		} catch (Throwable throwable) {
			// TODO: logging exception
			doLogWhenException(methodInfoMap, throwable.getMessage());
			throw throwable;
		}
	}

	private void doLogBeforeController(Map<String, String> methodInfoMap) {
		LOGGER.info(methodInfoMap.get(METHOD_NAME) + methodInfoMap.get(METHOD_ARGS));
	}
	
	private void doLogWhenException(Map<String, String> methodInfoMap, String message) {
		LOGGER.error(methodInfoMap.get(METHOD_NAME) + methodInfoMap.get(METHOD_ARGS) 
						+ "throws exception: " + message);
	}
	
	private Map<String, String> getMethodInfo(ProceedingJoinPoint joinPoint) {
		Map<String, String> methodInfoMap = new HashMap<String, String>();
		String className = joinPoint.getTarget().getClass().getName();
		Signature signature = joinPoint.getSignature();
		String controllerName = className + "." + signature.getName();
		methodInfoMap.put(METHOD_NAME, "call controller: " + controllerName);
		
		Object[] args = joinPoint.getArgs();
		String arg = parseParams(args);
		methodInfoMap.put(METHOD_ARGS, " args: " + arg);
		return methodInfoMap;
	}
	
	public String parseParams(Object[] params) {
		StringBuffer buf = new StringBuffer();
		for(Object param : params) {
			buf.append(param.getClass().getSimpleName().toString() + ":" + param.toString() + "\r\t");
		}
		return buf.toString();
	}
	
}
