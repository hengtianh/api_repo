package org.easy.develop.web.exception;

import org.easy.develop.web.base.WebModel;
import org.easy.develop.web.base.WebModelBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public WebModel handleNotFoundExp(NotFoundException e) {
		return new WebModelBuilder()
				.registNewStatus("404", e.getMessage(), true)
				.retData(e.getMessage())
				.build();
	}
	
	@ExceptionHandler(FileUploadException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR) 
	public WebModel handleFileUploadExp(FileUploadException e) {
		return new WebModelBuilder()
				.registNewStatus("401", e.getMessage(), true)
				.retData(e.getMessage())
				.build();
	}
}
