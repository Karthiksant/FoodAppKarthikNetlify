package com.karthik.springboot_FoodApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.karthik.springboot_FoodApp.dao.ProductDao;
import com.karthik.springboot_FoodApp.dto.FoodOrderDto;
import com.karthik.springboot_FoodApp.dto.ProductDto;
import com.karthik.springboot_FoodApp.util.ResponseStrucuture;

@Service
public class ProductService 
{
	@Autowired
	private ProductDao productDao;
	
	public ResponseStrucuture<ProductDto> saveProductDto(ProductDto productDto)
	{
		ResponseStrucuture<ProductDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.CREATED.value());
		responseStrucuture.setMessage("successfully inserted");
		responseStrucuture.setData(productDao.saveProductDto(productDto));
		return responseStrucuture;
	}
	public ResponseStrucuture<ProductDto> getProductDto(int id)
	{
		ResponseStrucuture<ProductDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.FOUND.value());
		responseStrucuture.setMessage("successfully displayed");
		responseStrucuture.setData(productDao.getProductDto(id));
		return responseStrucuture;
	}
	public ResponseStrucuture<List<ProductDto>> getAllProductDto()
	{
		ResponseStrucuture <List<ProductDto>> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.FOUND.value());
		responseStrucuture.setMessage("successfully displayed all");
		responseStrucuture.setData((List<ProductDto>) productDao.getAllProductDto());
		return responseStrucuture;
	}
	public ResponseStrucuture<ProductDto> deleteFoodOrderDto(int id)
	{
		ResponseStrucuture <ProductDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.OK.value());
		responseStrucuture.setMessage("successfully deleted");
		responseStrucuture.setData(productDao.deleteProductDto(id));
		return responseStrucuture;
		
	}
	public ResponseStrucuture<ProductDto> updateProductDto(int id,ProductDto productDto)
	{
		ResponseStrucuture <ProductDto> responseStrucuture=new ResponseStrucuture<>();
		responseStrucuture.setStatus(HttpStatus.OK.value());
		responseStrucuture.setMessage("successfully updated");
		responseStrucuture.setData(productDao.updateProductDto(id, productDto));
		return responseStrucuture;
	
	}
}
