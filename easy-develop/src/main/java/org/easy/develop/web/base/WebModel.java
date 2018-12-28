package org.easy.develop.web.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "接口返回结果对象")
public class WebModel {

	@ApiModelProperty("返回码")
	private String ret_code;
	@ApiModelProperty("返回状态描述")
	private String ret_msg;
	@ApiModelProperty("返回业务数据")
	private Object ret_data;

	public WebModel(String ret_code, String ret_msg, Object ret_data) {
		this.ret_code = ret_code;
		this.ret_msg = ret_msg;
		this.ret_data = ret_data;
	}

	public String getRet_code() {
		return ret_code;
	}

	public String getRet_msg() {
		return ret_msg;
	}

	public Object getRet_data() {
		return ret_data;
	}

}
