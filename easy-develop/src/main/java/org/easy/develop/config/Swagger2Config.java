package org.easy.develop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class Swagger2Config {
	private boolean enable = true;
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
					.title("前后端开发沟通平台")
					.description("前后端开发，对接口，需求，变更的沟通交流平台")
					.termsOfServiceUrl("http://localhost:8080/easy-develop")
					.version("1.0")
					.build();
	}
	
	@Bean("api接口模块")
	public Docket apiGroup() {
		return new Docket(DocumentationType.SWAGGER_2)
					.groupName("api group")
					.select()
					.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//					.paths(PathSelectors.ant("/apiDev/*"))
					.build()
					.apiInfo(apiInfo())
					.enable(enable);
	}
	
}
