package com.karthik.springboot_FoodApp.exception;

public class UserIdNotFound extends RuntimeException
{
	private String message1="id not found";
	
	public String getMessage1() {
		return message1;
	}
	//constructor
	public UserIdNotFound()
	{
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "im karthik";
	}
}
