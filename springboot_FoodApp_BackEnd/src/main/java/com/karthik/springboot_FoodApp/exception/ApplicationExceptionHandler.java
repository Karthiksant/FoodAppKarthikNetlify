package com.karthik.springboot_FoodApp.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler 
{
	@ExceptionHandler(UserIdNotFound.class)
	public String userIdNotFound(UserIdNotFound userIdNotFound)
	{
		return userIdNotFound.getMessage1()+userIdNotFound.toString();
	}
}
