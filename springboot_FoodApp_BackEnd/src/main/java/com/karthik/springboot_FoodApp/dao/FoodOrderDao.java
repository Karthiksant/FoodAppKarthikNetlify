package com.karthik.springboot_FoodApp.dao;
import java.util.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karthik.springboot_FoodApp.dto.FoodOrderDto;
import com.karthik.springboot_FoodApp.dto.ItemsDto;
import com.karthik.springboot_FoodApp.repo.FoodOrderRepo;

@Repository
public class FoodOrderDao {
	@Autowired
	private FoodOrderRepo foodOrderRepo;
	
	public FoodOrderDto saveFoodOrderDto(FoodOrderDto foodOrderDto)
	{
		return foodOrderRepo.save(foodOrderDto);
	}
	public FoodOrderDto deleteFoodOrderDto(int id)
	{
		FoodOrderDto foodOrderDto=foodOrderRepo.findById(id).get();
		foodOrderRepo.deleteById(id);
		return foodOrderDto;
	}
	public FoodOrderDto updateFoodOrderDto(int id,FoodOrderDto foodOrderDto)
	{
		FoodOrderDto foodOrderDto2=foodOrderRepo.findById(id).get();
		if(foodOrderDto2!=null)
		{
			foodOrderDto.setCustomerId(id);
		}
		return foodOrderRepo.save(foodOrderDto);
	}
	public FoodOrderDto updateFoodOrderDtoMethod2(int id,FoodOrderDto foodOrderDto)
	{
			foodOrderDto.setCustomerId(id);
			foodOrderDto.setItemsDtos(foodOrderDto.getItemsDtos());
			return foodOrderRepo.save(foodOrderDto);
	}
	public FoodOrderDto updateFoodOrderDtoMethod3(int id,FoodOrderDto foodOrderDto)
	{
			foodOrderDto.setCustomerId(id);
			foodOrderDto.setItemsDtos(foodOrderDto.getItemsDtos());
			return foodOrderRepo.save(foodOrderDto);
	}
	public FoodOrderDto  getoneord(int id)
	{
		return foodOrderRepo.findById(id).get();
	}
	public List<FoodOrderDto> getAllFoodOrderDtos()
	{
		return foodOrderRepo.findAll();
	}
	
}
