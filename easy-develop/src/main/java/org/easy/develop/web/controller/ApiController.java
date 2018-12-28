package org.easy.develop.web.controller;

import java.util.List;

import org.easy.develop.common.domain.DevApi;
import org.easy.develop.service.ApiService;
import org.easy.develop.service.FileService;
import org.easy.develop.web.base.WebModel;
import org.easy.develop.web.base.WebModelBuilder;
import org.easy.develop.web.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/apiDev")
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	
	@Autowired
	private FileService fileService;
	
	@ApiOperation(value = "更新api接口信息")
	@PostMapping("/apiUpdate")
	public WebModel updateApi(@RequestBody DevApi apiForm) {
		DevApi api = apiService.updateApi(apiForm);
		return new WebModelBuilder().buildSuccssfulModel(api);
	}
	
	@ApiOperation(value = "新增api接口信息")
	@PostMapping("/apiAdd")
	public WebModel addApi(DevApi apiForm, MultipartFile files) throws Exception {
		String filePath = fileService.uploadFile(files, "aaa");
		Long id = apiService.addApi(apiForm);
		apiForm.setId(id);
		return new WebModelBuilder().buildSuccssfulModel(apiForm);
	}
	
	@ApiOperation(value = "获得单个api接口信息")
	@GetMapping("/api/{id}")
	public WebModel getApi(@PathVariable long id) throws Exception {
		DevApi devApi = apiService.getApiById(id);
		if (devApi == null) {
			throw new NotFoundException("devApi id: " + id + " not found");
		}
		WebModel webModel = new WebModelBuilder()
								.buildSuccssfulModel(devApi);
		return webModel;
	}
	
	@ApiOperation(value = "获得api接口信息列表")
	@GetMapping("/apis")
	public WebModel listApi() {
		List<DevApi> devApis = apiService.listApi();
		WebModel webModel = new WebModelBuilder()
				.buildSuccssfulModel(devApis);
		return webModel;
	}
	
}
