package com.karthik.springboot_FoodApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karthik.springboot_FoodApp.dto.ItemsDto;
import com.karthik.springboot_FoodApp.repo.FoodOrderRepo;
import com.karthik.springboot_FoodApp.repo.ItemsRepo;

@Repository
public class ItemsDao {

	@Autowired
	private ItemsRepo itemsRepo;
	public ItemsDto saveItemsDto(ItemsDto itemsDto)
	{
		return itemsRepo.save(itemsDto);
	}
	public ItemsDto getOneItemsDto(int id)
	{
		return itemsRepo.findById(id).get();
	}
	public List<ItemsDto> getAllItemsDto()
	{
		return itemsRepo.findAll();
	}
	public ItemsDto deleteItemsDto(int id)
	{
		ItemsDto itemsDto=itemsRepo.findById(id).get();
		itemsRepo.deleteById(id);
		return itemsDto;
	}
	public ItemsDto updateItemsDto(int id,ItemsDto itemsDto)
	{
		ItemsDto itemsDto2=itemsRepo.findById(id).get();
		if(itemsDto2!=null)
		{
			itemsDto.setItemId(id);
		}
		return itemsRepo.save(itemsDto);
	}
}
