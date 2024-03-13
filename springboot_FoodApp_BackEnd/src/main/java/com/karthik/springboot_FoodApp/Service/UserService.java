package com.karthik.springboot_FoodApp.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karthik.springboot_FoodApp.dao.UserDao;
import com.karthik.springboot_FoodApp.dto.FoodOrderDto;
import com.karthik.springboot_FoodApp.dto.ProductDto;
import com.karthik.springboot_FoodApp.dto.UserDto;
import com.karthik.springboot_FoodApp.exception.UserIdNotFound;
import com.karthik.springboot_FoodApp.util.ResponseStrucuture;

@Service
public class UserService
{
	@Autowired
	private UserDao userDao;
	
	public ResponseEntity<ResponseStrucuture<UserDto>> saveUser(UserDto userDto)
	{
		ResponseStrucuture <UserDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.CREATED.value());
		responseStrucuture.setMessage("successfully inserted");
		responseStrucuture.setData(userDao.saveUserDto(userDto));
		return new ResponseEntity<ResponseStrucuture<UserDto>>(responseStrucuture,HttpStatus.CREATED);
	
	}
	public ResponseEntity<ResponseStrucuture<UserDto>> getUserDto(int id)
	{
		ResponseStrucuture <UserDto> responseStrucuture=new ResponseStrucuture<>();
		UserDto userDto=userDao.getUserDto(id);
		if(userDto!=null)
		{
			responseStrucuture.setStatus(HttpStatus.FOUND.value());
			responseStrucuture.setMessage("successfully displayed");
			responseStrucuture.setData(userDao.getUserDto(id));
			return new ResponseEntity<ResponseStrucuture<UserDto>>(responseStrucuture,HttpStatus.FOUND);
		}
		else
		{
			throw new UserIdNotFound();
		}	
	}
	public ResponseStrucuture<List<UserDto>> getAllUserDto()
	{
		ResponseStrucuture <List<UserDto>> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.FOUND.value());
		responseStrucuture.setMessage("successfully displayed");
		responseStrucuture.setData((List<UserDto>) userDao.getAllUserDto());
		return responseStrucuture;
	}
	public ResponseStrucuture<UserDto> deleteUserDto(int id)
	{
		ResponseStrucuture <UserDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.OK.value());
		responseStrucuture.setMessage("successfully deleted");
		responseStrucuture.setData(userDao.deleteUserDto(id));
		return responseStrucuture;

	}
	public ResponseStrucuture<UserDto> updatUserDto(int id,UserDto userDto)
	{
		ResponseStrucuture <UserDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.OK.value());
		responseStrucuture.setMessage("successfully updated");
		responseStrucuture.setData(userDao.updatUserDto(id,userDto));
		return responseStrucuture;
	
	}
}
