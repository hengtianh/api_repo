package org.easy.develop.web.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 前端web统一数据模型
 * @author Administrator
 *
 */
public class WebModelBuilder {
	/**
	 * 定义返回状态和返回信息
	 */
	private static final String SUCCESS = "200";
	private static final String ERR = "404";
	private static final String BADSERVER = "500";
	
	private static final String SUCCESS_MSG = "SUCCESS";
	private static final String SUCCESS_NOTFOUND_MSG = "SUCCESS";
	private static final String ERR_MSG = "ERROR";
	private static final String BADSERVER_MSG = "BADSERVER";
	
	private String ret_code;
	private String ret_msg;
	private Object ret_data;
	
	private static Map<String, String> defaultRetStatusMap;
	
	private Map<String, String> retStatusMap = new HashMap<String, String>(0);
	
	static {
		defaultRetStatusMap = new HashMap<String, String>(4);
		defaultRetStatusMap.put(SUCCESS, SUCCESS_MSG);
		defaultRetStatusMap.put(SUCCESS, SUCCESS_NOTFOUND_MSG);
		defaultRetStatusMap.put(ERR, ERR_MSG);
		defaultRetStatusMap.put(BADSERVER, BADSERVER_MSG);
	}

	public WebModel buildErrModel() {
		return buildRetStatus(ERR, ERR_MSG)
				.retData(null)
				.build();
	}
	
	public WebModel buildNullModel() {
		return buildRetStatus(SUCCESS, SUCCESS_NOTFOUND_MSG)
				.retMsg("not exists")
				.retData(null)
				.build();
	}
	
	public WebModel buildSuccssfulModel(Object data) {
		return buildRetStatus(SUCCESS, SUCCESS_MSG)
				.retData(data)
				.build();
	}
	
	public WebModel buildFailedModel() {
		return buildRetStatus(BADSERVER, BADSERVER_MSG)
				.retData(null)
				.build();
	}

	private WebModelBuilder retCode(String ret_code) {
		this.ret_code = ret_code;
		return this;
	}

	private WebModelBuilder retMsg(String ret_msg) {
		this.ret_msg = ret_msg;
		return this;
	}

	public WebModelBuilder retData(Object data) {
		this.ret_data = data;
		return this;
	}

	public WebModel build() {
		return new WebModel(ret_code, ret_msg, ret_data);
	}
	
	public WebModelBuilder registNewStatus(String ret_code, String ret_msg, boolean override) {
		String new_ret_msg = registRetStatus(ret_code, ret_msg.toUpperCase(), override);
		return buildRetStatus(ret_code, new_ret_msg);
	}
	
	private WebModelBuilder buildRetStatus(String ret_code, String ret_msg) {
		return retCode(ret_code)
				.retMsg(ret_msg);
	}
	
	private String registRetStatus(String ret_code, String ret_msg, boolean override) {
		if (override) {
			/*
			 * 重写状态：
			 * 	ret_code相同，ret_msg不同，使用新的ret_msg，并保存
			 *  ret_code相同，ret_msg相同，使用默认的状态，不保存
			 *  ret_code不相同，使用新的状态，保存
			 */
			if (defaultRetStatusMap.containsKey(ret_code) && 
					defaultRetStatusMap.containsValue(ret_msg)) {
				return defaultRetStatusMap.get(ret_code);
			}
			retStatusMap.put(ret_code, ret_msg);
			return retStatusMap.get(ret_code);
		}
		if (!override && !defaultRetStatusMap.containsKey(ret_code)) {
			retStatusMap.put(ret_code, ret_msg);
			return retStatusMap.get(ret_code);
		}
		return defaultRetStatusMap.get(ret_code);
	}

}
