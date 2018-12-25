package org.easy.develop.web.exception;

public class FileUploadException extends RuntimeException{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

	public FileUploadException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return msg;
	}
	
}
