package com.karthik.springboot_FoodApp.controller;

import java.util.*;
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

import com.karthik.springboot_FoodApp.Service.FoodOrderService;
import com.karthik.springboot_FoodApp.dao.FoodOrderDao;
import com.karthik.springboot_FoodApp.dto.FoodOrderDto;
import com.karthik.springboot_FoodApp.dto.ItemsDto;
import com.karthik.springboot_FoodApp.util.ResponseStrucuture;

@RestController
public class FoodOrderController
{
	@Autowired
	private FoodOrderService foodOrderService;
	
	@PostMapping("/saveFoodOrder")
	public ResponseEntity<ResponseStrucuture<FoodOrderDto>> savefFoodOrder(@RequestBody FoodOrderDto foodOrderDto)
	{
		return foodOrderService.saveFoodOrderDto(foodOrderDto);
	}
	@GetMapping("/getOneFoodOrder")
	public ResponseEntity<ResponseStrucuture<FoodOrderDto>> geFoodOrderDto(@RequestParam int id)
	{
		return foodOrderService.getFoodOrderDto(id);
	}
	@GetMapping("/getAllFoodOrder")
	public ResponseStrucuture<List<FoodOrderDto>> getAllFoodOrderDto()
	{
		return foodOrderService.getAllFoodOrderDtos();
	}
	
	@DeleteMapping("/deleteFoodOrder")
	public ResponseEntity<ResponseStrucuture<FoodOrderDto>> deleteFoodOrderDto(@RequestParam int id)
	{
		return foodOrderService.deleteFoodOrderDto(id);
	}
	@PutMapping("/updateFoodOrder")
	public ResponseEntity<ResponseStrucuture<FoodOrderDto>> updateFoodOrderDto(@RequestBody FoodOrderDto foodOrderDto,
											@RequestParam int id)
	{
		return foodOrderService.updateFoodOrderDto(id, foodOrderDto);
	}
	@PutMapping("/updateFoodOrderMethod2")
	public ResponseStrucuture<FoodOrderDto> updateFoodOrderDtoMethod2(@RequestBody FoodOrderDto foodOrderDto,
											@RequestParam int id)
	{
		return foodOrderService.updateFoodOrderDtoMethod2(id, foodOrderDto);
	}
	@PutMapping("/updateFoodOrderMethod3plus")
	public FoodOrderDto updateFoodOrderDtoMethod2WithCalculation(@RequestBody FoodOrderDto foodOrderDto,
											@RequestParam int id)
	{
		return foodOrderService.updateFoodOrderDtoMethod3Withcalculation(id, foodOrderDto);
	}
}
