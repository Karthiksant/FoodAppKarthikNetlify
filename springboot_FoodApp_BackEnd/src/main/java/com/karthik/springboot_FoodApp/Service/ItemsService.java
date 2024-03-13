package com.karthik.springboot_FoodApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.karthik.springboot_FoodApp.dao.ItemsDao;
import com.karthik.springboot_FoodApp.dto.ItemsDto;
import com.karthik.springboot_FoodApp.util.ResponseStrucuture;

@Service
public class ItemsService 
{
	@Autowired
	private ItemsDao itemsDao;
	
	public ResponseStrucuture<ItemsDto> saveItemsDto(ItemsDto itemsDto)
	{
		ResponseStrucuture< ItemsDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.CREATED.value());
		responseStrucuture.setMessage("successfully inserted");
		responseStrucuture.setData(itemsDao.saveItemsDto(itemsDto));
		return responseStrucuture;
	}
	public ResponseStrucuture<ItemsDto> getItemsDto(int id)
	{
		ResponseStrucuture< ItemsDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.FOUND.value());
		responseStrucuture.setMessage("successfully displayed");
		responseStrucuture.setData(itemsDao.getOneItemsDto(id));
		return responseStrucuture;
	}
	public ResponseStrucuture<List<ItemsDto>> getAllItemsDto()
	{
		ResponseStrucuture<List<ItemsDto>> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.FOUND.value());
		responseStrucuture.setMessage("successfully displayed all");
		responseStrucuture.setData((List<ItemsDto>) itemsDao.getAllItemsDto());
		return responseStrucuture;
	}
	public ResponseStrucuture<ItemsDto> delteItemsDto(int id)
	{
		ResponseStrucuture< ItemsDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.OK.value());
		responseStrucuture.setMessage("successfully deleted");
		responseStrucuture.setData(itemsDao.deleteItemsDto(id));
		return responseStrucuture;
	}
	public ResponseStrucuture<ItemsDto> updateItemsDto(int id,ItemsDto itemsDto)
	{
		ResponseStrucuture< ItemsDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.OK.value());
		responseStrucuture.setMessage("successfully updated");
		responseStrucuture.setData(itemsDao.updateItemsDto(id, itemsDto));
		return responseStrucuture;
	}

}
