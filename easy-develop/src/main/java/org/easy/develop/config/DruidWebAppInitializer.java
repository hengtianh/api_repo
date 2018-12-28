package org.easy.develop.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * Servlet implementation class DruidWebAppInitializer
 */
public class DruidWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		Dynamic servlet = servletContext.addServlet("StatViewServlet", StatViewServlet.class);
		servlet.addMapping("/druid/*");
		
		javax.servlet.FilterRegistration filterRegistration = servletContext.addFilter("WebStatFilter", WebStatFilter.class);
		filterRegistration.setInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		filterRegistration.addMappingForUrlPatterns(null, false, "/*");
	}


}
