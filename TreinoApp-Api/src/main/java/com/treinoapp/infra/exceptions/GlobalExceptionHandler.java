package com.treinoapp.infra.exceptions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class GlobalExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(value = InvalidRequestParamException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public List<DefaultError> handleInvalidRequestParamException(InvalidRequestParamException e) {
		logger.debug("handleInvalidRequestParamException");
		List<DefaultError> erros = e.getErros();
		return erros;
	}

	@ExceptionHandler(value = MyEntityNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public List<DefaultError> handleMyEntityNotFoundException(MyEntityNotFoundException e) {
		logger.debug("MyEntityNotFoundException");
		List<DefaultError> erros = e.getErros();
		return erros;
	}
	
	@ExceptionHandler(value = RequestConflictException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public List<DefaultError> handleRequestConflictException(RequestConflictException e) {
		logger.debug("RequestConflictException");
		List<DefaultError> erros = e.getErros();
		return erros;
	}
}