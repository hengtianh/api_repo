package org.easy.develop.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.easy.develop.common.domain.DevApi;
import org.easy.develop.web.base.WebModel;
import org.easy.develop.web.base.WebModelBuilder;
import org.easy.develop.web.exception.FileUploadException;
import org.easy.develop.web.exception.NotFoundException;
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
	
	@ApiOperation(value = "更新api接口信息")
	@PostMapping("/apiUpdate")
	public WebModel updateApi(@RequestBody DevApi apiForm) {
		// , emulateJSON
		return new WebModelBuilder().buildSuccssfulModel(null);
	}
	
	@ApiOperation(value = "新增api接口信息")
	@PostMapping("/apiAdd")
	public WebModel addApi(DevApi apiForm, MultipartFile[] files) throws Exception {
		uploadFile(files[0], "aaa");
		apiForm.setApiName("success add and upload file");
		return new WebModelBuilder().buildSuccssfulModel(apiForm);
	}
	
	@ApiOperation(value = "获得单个api接口信息")
	@GetMapping("/api/{id}")
	public WebModel getApi(@PathVariable long id) throws Exception {
		DevApi devApi = new DevApi();
		devApi.setId(id);
		devApi.setApiName("listApi");
		devApi.setReturnType("WebModel");
		devApi.setParams(Long.toString(id));
		devApi.setDescription("返回所api列表");
		devApi.setAuthor("administrator");
		devApi.setGmtCreate(new Date());
		devApi.setIsEnabled((byte) 1);
		
		devApi = id > 1L ? devApi : null;
		
		if (devApi == null) {
			throw new NotFoundException("devApi id: " + id + " not found");
		}
		
		WebModel webModel = new WebModelBuilder()
								.buildSuccssfulModel(devApi);
		/*webModel = new WebModelBuilder()
						.registNewStatus("200", "success", true)
						.retData(devApi)
						.build();*/
		return webModel;
	}
	
	@ApiOperation(value = "获得api接口信息列表")
	@GetMapping("/apis")
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
	
	/**
	 * 文件上传接口，按指定文件名保存文件
	 * @param multipartFile
	 * @param filename
	 * @throws FileUploadException
	 */
	private void uploadFile(MultipartFile multipartFile, String filename) throws FileUploadException {
		String originalFilename = multipartFile.getOriginalFilename();
		String suffix = originalFilename.substring(originalFilename.lastIndexOf('.'));
		String newFilename = filename + suffix;
		String uploadPath = "d:/upload/";
		File dest = new File(uploadPath + newFilename);
		try {
			multipartFile.transferTo(dest);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new FileUploadException("failed to upload file: '" + originalFilename + "'");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new FileUploadException("failed to upload file: '" + originalFilename + "'");
		}
	}
	
}
