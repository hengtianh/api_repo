package org.easy.develop.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "org.easy.develop.web.aop" }, includeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = Aspect.class) })
public class AopConfig {

}
