package org.easy.develop.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 基于servlet3.0,使用javaConfig配置容器
 * @author Administrator
 *
 */
public class ApiRepoWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO 配置ContextLoaderListener上下文配类
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO 配置Dispatcher上下文的配置类
		return new Class[] {WebConfig.class, AopConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO 配置DispatcherServlet 处理的请求路径  /: 所以请求
		return new String[] {"/"};
	}

}
