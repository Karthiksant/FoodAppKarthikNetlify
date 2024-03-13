package com.karthik.springboot_FoodApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karthik.springboot_FoodApp.Service.UserService;
import com.karthik.springboot_FoodApp.dao.UserDao;
import com.karthik.springboot_FoodApp.dto.FoodOrderDto;
import com.karthik.springboot_FoodApp.dto.UserDto;
import com.karthik.springboot_FoodApp.util.ResponseStrucuture;

@RestController
@CrossOrigin("http://localhost:5174")
public class UserController
{
	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUser")
	public ResponseEntity<ResponseStrucuture<UserDto>> saveUserDto(@RequestBody UserDto userDto)
	{
		return userService.saveUser(userDto);
	}
	@GetMapping("/getOneUser")
	public ResponseEntity<ResponseStrucuture<UserDto>> getUserDto(@RequestParam int id)
	{
		return userService.getUserDto(id);
	}
	@GetMapping("/getAllUsers")
	public ResponseStrucuture <List<UserDto>> getAllUserDto()
	{
		return userService.getAllUserDto();
	}
	@DeleteMapping("/deleteUser")
	public ResponseStrucuture <UserDto> deleteUserDto(@RequestParam int id)
	{
		return userService.deleteUserDto(id);
	}
	@PutMapping("/updateUser")
	public ResponseStrucuture <UserDto> updateUserDto(@RequestBody UserDto userDto,
											@RequestParam int id)
	{
		return userService.updatUserDto(id, userDto);
	}

}
