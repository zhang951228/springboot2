package com.erayt.single.configuration.spring.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Auther: Z151
 * @Date: 2021/3/10 15:31
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandle {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handler(Exception e) {
		log.error(e.getMessage(), e);
		return e.getMessage();
	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String handler(RuntimeException e) {
		log.error(e.getMessage(), e);
		return e.getMessage();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public String handler(MethodArgumentNotValidException e) {
		log.error(e.getMessage(), e);
		return e.getMessage();
	}

	@ExceptionHandler(BindException.class)
	@ResponseBody
	public String handler(BindException e) {
		log.error(e.getMessage(), e);
		return e.getMessage();
	}
}
