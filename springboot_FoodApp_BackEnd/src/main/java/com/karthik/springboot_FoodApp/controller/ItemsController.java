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

import com.karthik.springboot_FoodApp.Service.ItemsService;
import com.karthik.springboot_FoodApp.dao.ItemsDao;
import com.karthik.springboot_FoodApp.dto.FoodOrderDto;
import com.karthik.springboot_FoodApp.dto.ItemsDto;
import com.karthik.springboot_FoodApp.util.ResponseStrucuture;

@RestController
@CrossOrigin("http://localhost:5174")
public class ItemsController
{
	@Autowired
	private ItemsService itemsService;
	
	@PostMapping("/saveItems")
	public ResponseStrucuture<ItemsDto> saveItemsDto(@RequestBody ItemsDto itemsDto)
	{
		return itemsService.saveItemsDto(itemsDto);
	}
	@GetMapping("/getOneItem")
	public ResponseStrucuture<ItemsDto>  getItemsDto(@RequestParam int id)
	{
		return itemsService.getItemsDto(id);
	}
	@GetMapping("/getAllItem")
	public ResponseStrucuture<List<ItemsDto>>  getAllItemsDto()
	{
		return itemsService.getAllItemsDto();
	}
	@DeleteMapping("/deleteItem")
	public ResponseStrucuture<ItemsDto> deleteItemsDto(@RequestParam int id)
	{
		return itemsService.delteItemsDto(id);
	}
	@PutMapping("/updateItem")
	public ResponseStrucuture<ItemsDto> updateItemsDto(@RequestBody ItemsDto itemsDto,
									@RequestParam int id)
	{
		return itemsService.updateItemsDto(id,itemsDto);
	}

}
