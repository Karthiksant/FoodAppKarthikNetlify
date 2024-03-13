package com.karthik.springboot_FoodApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.karthik.springboot_FoodApp.dao.MenuDao;
import com.karthik.springboot_FoodApp.dto.FoodOrderDto;
import com.karthik.springboot_FoodApp.dto.MenuDto;
import com.karthik.springboot_FoodApp.util.ResponseStrucuture;

@Service
public class MenuService
{
	@Autowired
	private MenuDao menuDao;
	
	public ResponseStrucuture<MenuDto> saveMenuDto(MenuDto menuDto)
	{
		ResponseStrucuture< MenuDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.CREATED.value());
		responseStrucuture.setMessage("successfully inserted");
		responseStrucuture.setData(menuDao.savMenuDto(menuDto));
		return responseStrucuture;
	}
	public ResponseStrucuture<MenuDto> getMenuDto(int id)
	{
		ResponseStrucuture< MenuDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.FOUND.value());
		responseStrucuture.setMessage("successfully displayed");
		responseStrucuture.setData(menuDao.getoneMenuDto(id));
		return responseStrucuture;
	}
	public ResponseStrucuture<List<MenuDto>> getAllMenuDto()
	{
		ResponseStrucuture<List<MenuDto>> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.FOUND.value());
		responseStrucuture.setMessage("successfully displayed all");
		responseStrucuture.setData((List<MenuDto>) menuDao.getAllMenuDto());
		return responseStrucuture;
	}
	public ResponseStrucuture<MenuDto> deleteMenuDto(int id)
	{
		ResponseStrucuture< MenuDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.OK.value());
		responseStrucuture.setMessage("successfully deleted");
		responseStrucuture.setData(menuDao.deleteMenuDto(id));
		return responseStrucuture;
	}
	public ResponseStrucuture<MenuDto> updateMenuDto(int id,MenuDto menuDto)
	{
		ResponseStrucuture< MenuDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.OK.value());
		responseStrucuture.setMessage("successfully updated");
		responseStrucuture.setData(menuDao.updateMenuDto(id, menuDto));
		return responseStrucuture;
	}

}
