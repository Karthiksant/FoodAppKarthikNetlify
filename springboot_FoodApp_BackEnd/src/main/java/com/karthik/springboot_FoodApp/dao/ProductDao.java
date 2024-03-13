package com.karthik.springboot_FoodApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karthik.springboot_FoodApp.dto.FoodOrderDto;
import com.karthik.springboot_FoodApp.dto.ProductDto;
import com.karthik.springboot_FoodApp.repo.ProductRepo;

@Repository
public class ProductDao {
 
	@Autowired
	private ProductRepo productRepo;
	
	public ProductDto saveProductDto(ProductDto productDto)
	{
		return productRepo.save(productDto);
	}
	public ProductDto  getProductDto(int id)
	{
		return productRepo.findById(id).get();
	}
	public List<ProductDto>  getAllProductDto()
	{
		return productRepo.findAll();
	}
	public ProductDto deleteProductDto(int id)
	{
		ProductDto productDto=productRepo.findById(id).get();
		productRepo.deleteById(id);
		return productDto;
	}
	public ProductDto updateProductDto(int id,ProductDto productDto)
	{
		ProductDto productDto2=productRepo.findById(id).get();
		if(productDto2!=null)
		{
			productDto.setProductId(id);
		}
		return productRepo.save(productDto);
	}
}
