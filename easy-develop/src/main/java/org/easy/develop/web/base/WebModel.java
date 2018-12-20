package org.easy.develop.web.base;

public class WebModel {

	public String ret_code;
	public String ret_msg;
	public Object ret_data;

	protected WebModel() {
	}

	public void setRet_code(String ret_code) {
		this.ret_code = ret_code;
	}

	public void setRet_msg(String ret_msg) {
		this.ret_msg = ret_msg;
	}

	public void setRet_data(Object ret_data) {
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
