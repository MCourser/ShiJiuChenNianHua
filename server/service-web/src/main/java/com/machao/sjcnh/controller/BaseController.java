package com.machao.sjcnh.controller;

import org.springframework.validation.Errors;

import com.machao.sjcnh.exception.RequestParamsErrorException;

public class BaseController {
	
	protected void checkRequestParams(Errors errors) {
		if(errors.hasErrors()) {
			throw new RequestParamsErrorException();
		}
	}
	
}
