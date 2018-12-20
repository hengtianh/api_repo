package org.easy.develop.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
		devApi.setParams(Long.toString(id));
		devApi.setDescription("返回所api列表");
		devApi.setAuthor("administrator");
		devApi.setGmtCreate(new Date());
		devApi.setIsEnabled((byte) 1);
		
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
		devApi.setParams("1");
		devApi.setDescription("返回所api列表");
		devApi.setAuthor("administrator");
		devApi.setGmtCreate(new Date());
		devApi.setIsEnabled((byte) 1);
		
		DevApi devApi2 = new DevApi();
		devApi2.setId(1L);
		devApi2.setApiName("gete");
		devApi2.setReturnType("WebModel");
		devApi2.setParams("2");
		devApi2.setDescription("返回所api列表");
		devApi2.setAuthor("administrator");
		devApi2.setGmtCreate(new Date());
		devApi2.setIsEnabled((byte) 1);
		
		List<DevApi> devApis = new ArrayList<>();
		devApis.add(devApi);
		devApis.add(devApi2);
		
		WebModel webModel = new WebModelBuilder()
				.buildSuccssfulModel(devApis);
		
		/*webModel = new WebModelBuilder()
						.registNewStatus("200", "success", true)
						.retData(devApi)
						.build();*/
		return webModel;
	}
	
}
