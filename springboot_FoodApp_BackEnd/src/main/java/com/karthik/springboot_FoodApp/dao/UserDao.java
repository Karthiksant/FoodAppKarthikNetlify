package com.karthik.springboot_FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karthik.springboot_FoodApp.dto.FoodOrderDto;
import com.karthik.springboot_FoodApp.dto.UserDto;
import com.karthik.springboot_FoodApp.repo.UserRepo;

@Repository
public class UserDao 
{
	@Autowired
	private UserRepo userRepo;
	public UserDto saveUserDto(UserDto userDto)
	{
		return userRepo.save(userDto);
	}
	public UserDto  getUserDto(int id)
	{
		Optional<UserDto> userDto=userRepo.findById(id);
		if(userDto.isPresent()){
		return userRepo.findById(id).get();}
		else {
		return null;
		}
		//return userRepo.findById(id).get();
	}
	public List<UserDto>  getAllUserDto()
	{
		return userRepo.findAll();
	}
	public UserDto deleteUserDto(int id)
	{
		UserDto userDto=userRepo.findById(id).get();
		userRepo.deleteById(id);
		return userDto;
	}
	public UserDto updatUserDto(int id,UserDto userDto)
	{
		UserDto userDto2=userRepo.findById(id).get();
		if(userDto2!=null)
		{
			userDto.setUserId(id);
		}
		return userRepo.save(userDto);
	}
}
