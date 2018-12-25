package org.easy.develop.web.exception;

public class NotFoundException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public NotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	
}
