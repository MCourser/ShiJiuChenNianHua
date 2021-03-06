package com.machao.sjcnh.controller;

import java.nio.file.AccessDeniedException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.machao.sjcnh.exception.RequestParamsErrorException;
import com.machao.sjcnh.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler({
		DataIntegrityViolationException.class, 
		ResourceNotFoundException.class,
		AccessDeniedException.class,
		RequestParamsErrorException.class
	})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ResponseEntity<String> dataIntegrityViolationException(Exception e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}   
}