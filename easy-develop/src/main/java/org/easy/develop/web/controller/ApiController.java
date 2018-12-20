package org.easy.develop.web.controller;

import java.util.Date;

import org.easy.develop.common.domain.DevApi;
import org.easy.develop.web.base.WebModel;
import org.easy.develop.web.base.WebModelBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiDev")
public class ApiController {
	
	@GetMapping()
	public String home() {
		return "home";
	}
	
	@GetMapping("/api/{id}")
	@ResponseBody
	public WebModel getApi(@PathVariable long id) {
		DevApi devApi = new DevApi();
		devApi.setId(id);
		devApi.setApiName("listApi");
		devApi.setReturnType("WebModel");
		devApi.setParams(null);
		devApi.setDescription("返回所api列表");
		devApi.setAuthor("administrator");
		devApi.setGmtCreate(new Date());
		devApi.setIsEnabled((byte) 0);
		
		WebModel webModel = new WebModelBuilder()
								.buildSuccssfulModel(devApi);
		/*webModel = new WebModelBuilder()
						.registNewStatus("200", "success", true)
						.retData(devApi)
						.build();*/
		return webModel;
	}
	
	@GetMapping("/apis")
	@ResponseBody
	public WebModel listApi() {
		DevApi devApi = new DevApi();
		devApi.setId(1L);
		devApi.setApiName("listApi");
		devApi.setReturnType("WebModel");
		devApi.setParams(null);
		devApi.setDescription("返回所api列表");
		devApi.setAuthor("administrator");
		devApi.setGmtCreate(new Date());
		devApi.setIsEnabled((byte) 0);
		
		WebModel webModel = new WebModelBuilder()
								.buildSuccssfulModel(devApi);
		/*webModel = new WebModelBuilder()
						.registNewStatus("200", "success", true)
						.retData(devApi)
						.build();*/
		return webModel;
	}
	
}
