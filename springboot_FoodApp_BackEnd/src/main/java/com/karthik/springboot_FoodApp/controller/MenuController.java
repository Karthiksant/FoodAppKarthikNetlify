package com.karthik.springboot_FoodApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karthik.springboot_FoodApp.Service.MenuService;
import com.karthik.springboot_FoodApp.dao.MenuDao;
import com.karthik.springboot_FoodApp.dto.FoodOrderDto;
import com.karthik.springboot_FoodApp.dto.MenuDto;
import com.karthik.springboot_FoodApp.util.ResponseStrucuture;

@RestController
@CrossOrigin("http://localhost:5174")
public class MenuController
{
	@Autowired
	private MenuService menuService;
	@PostMapping("/saveMenu")
	public ResponseStrucuture<MenuDto> savMenuDto(@RequestBody MenuDto menuDto)
	{
		return menuService.saveMenuDto(menuDto);
	}
	@GetMapping("/getOneMenu")
	public ResponseStrucuture<MenuDto> getmMenuDto(@RequestParam int id)
	{
		return menuService.getMenuDto(id);
	}
	@GetMapping("/getAllMenu")
	public ResponseStrucuture<List<MenuDto>> getAllMenuDto()
	{
		return menuService.getAllMenuDto();
	}
	@DeleteMapping("/deleteOneMenu")
	public ResponseStrucuture<MenuDto> deletMenuDto(@RequestParam int id)
	{
		return menuService.deleteMenuDto(id);
	}
	@PutMapping("/updateMenu")
	public ResponseStrucuture<MenuDto> updateMenuDto(@RequestBody MenuDto menuDto,
											@RequestParam int id)
	{
		return menuService.updateMenuDto(id, menuDto);
	}
}
