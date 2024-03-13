package com.karthik.springboot_FoodApp.Service;
import java.util.*;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karthik.springboot_FoodApp.util.*;
import com.karthik.springboot_FoodApp.dao.FoodOrderDao;
import com.karthik.springboot_FoodApp.dto.FoodOrderDto;
import com.karthik.springboot_FoodApp.dto.ItemsDto;
@Service
public class FoodOrderService 
{
	@Autowired
	private FoodOrderDao foodOrderDao;	
	public  ResponseEntity<ResponseStrucuture<FoodOrderDto>> saveFoodOrderDto(FoodOrderDto foodOrderDto)
	{		
		List<ItemsDto> list=foodOrderDto.getItemsDtos();
		double totalPrice=0.0;
	for(ItemsDto items:list)
	{ 
		totalPrice=totalPrice+items.getItemPrice()*items.getItemQuantity();
	}
	ResponseStrucuture<FoodOrderDto> responseStrucuture=new ResponseStrucuture<>();
	responseStrucuture.setStatus(HttpStatus.CREATED.value());
	responseStrucuture.setMessage("successfully inserted");
	responseStrucuture.setData(foodOrderDao.saveFoodOrderDto(foodOrderDto));
	return new  ResponseEntity<ResponseStrucuture<FoodOrderDto>>(responseStrucuture,HttpStatus.CREATED);
	}
	public FoodOrderDto updateFoodOrderDtoMethod3Withcalculation(int id,FoodOrderDto foodOrderDto)
	{
		List<ItemsDto> list=foodOrderDto.getItemsDtos();
		double totalPrice=0.0;
for(ItemsDto items:list)
{ 
	totalPrice=totalPrice+items.getItemPrice()*items.getItemQuantity();
}
		foodOrderDto.setCustomerPrice(totalPrice);
		
		return foodOrderDao.updateFoodOrderDtoMethod3(id,foodOrderDto);
	}
	public ResponseEntity<ResponseStrucuture<FoodOrderDto>> getFoodOrderDto(int id)
	{
		ResponseStrucuture< FoodOrderDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.FOUND.value());
		responseStrucuture.setMessage("data fetched successfully");
		responseStrucuture.setData(foodOrderDao.getoneord(id));
		return new ResponseEntity<ResponseStrucuture<FoodOrderDto>>(responseStrucuture,HttpStatus.FOUND);
	}
	public ResponseStrucuture<List<FoodOrderDto>> getAllFoodOrderDtos()
	{
		ResponseStrucuture<List<FoodOrderDto>> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.FOUND.value());
		responseStrucuture.setMessage("Alldata fetched successfully");
		responseStrucuture.setData((List<FoodOrderDto>) foodOrderDao.getAllFoodOrderDtos());
		return responseStrucuture;
	}
	public ResponseEntity<ResponseStrucuture<FoodOrderDto>> deleteFoodOrderDto(int id)
	{
		ResponseStrucuture< FoodOrderDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.OK.value());
		responseStrucuture.setMessage("data deleted successfully");
		responseStrucuture.setData(foodOrderDao.deleteFoodOrderDto(id));
		return new ResponseEntity<ResponseStrucuture<FoodOrderDto>>(responseStrucuture,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStrucuture<FoodOrderDto>> updateFoodOrderDto(int id,FoodOrderDto foodOrderDto)
	{
		ResponseStrucuture< FoodOrderDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.OK.value());
		responseStrucuture.setMessage("data updated successfully");
		responseStrucuture.setData(foodOrderDao.updateFoodOrderDto(id,foodOrderDto));
		return  new ResponseEntity<ResponseStrucuture<FoodOrderDto>>(responseStrucuture,HttpStatus.OK);
	}
	public ResponseStrucuture<FoodOrderDto> updateFoodOrderDtoMethod2(int id,FoodOrderDto foodOrderDto)
	{
		ResponseStrucuture< FoodOrderDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.OK.value());
		responseStrucuture.setMessage("data updated successfully");
		responseStrucuture.setData(foodOrderDao.updateFoodOrderDtoMethod2(id,foodOrderDto));
		return responseStrucuture;
	}
}