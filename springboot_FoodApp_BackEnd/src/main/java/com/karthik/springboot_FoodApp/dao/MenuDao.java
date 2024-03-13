package com.karthik.springboot_FoodApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karthik.springboot_FoodApp.dto.FoodOrderDto;
import com.karthik.springboot_FoodApp.dto.MenuDto;
import com.karthik.springboot_FoodApp.repo.MenuRepo;

@Repository
public class MenuDao {

	@Autowired
	private MenuRepo menuRepo;
	
	public MenuDto savMenuDto(MenuDto menuDto)
	{
		return menuRepo.save(menuDto);
	}
	public MenuDto  getoneMenuDto(int id)
	{
		return menuRepo.findById(id).get();
	}
	public List<MenuDto>  getAllMenuDto()
	{
		return menuRepo.findAll();
	}
	public MenuDto deleteMenuDto(int id)
	{
		MenuDto menuDto=menuRepo.findById(id).get();
		menuRepo.deleteById(id);
		return menuDto;
	}
	public MenuDto updateMenuDto(int id,MenuDto menuDto)
	{
		MenuDto menuDto2=menuRepo.findById(id).get();
		if(menuDto2!=null)
		{
			menuDto.setMenuId(id);
		}
		return menuRepo.save(menuDto);
	}

}
