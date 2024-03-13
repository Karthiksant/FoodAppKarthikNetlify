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

import com.karthik.springboot_FoodApp.Service.ProductService;
import com.karthik.springboot_FoodApp.dao.ProductDao;
import com.karthik.springboot_FoodApp.dto.FoodOrderDto;
import com.karthik.springboot_FoodApp.dto.ProductDto;
import com.karthik.springboot_FoodApp.util.ResponseStrucuture;

@RestController
@CrossOrigin("http://localhost:5174")
public class ProductController
{
	@Autowired
	private ProductService productService;
	
	@PostMapping("/saveProduct")
	public ResponseStrucuture<ProductDto> savProductDto(@RequestBody ProductDto productDto)
	{
		return productService.saveProductDto(productDto);
	}
	@GetMapping("/getOneProduct")
	public ResponseStrucuture<ProductDto> getpProductDto(@RequestParam int id)
	{
		return productService.getProductDto(id);
	}
	@GetMapping("/getAllProduct")
	public ResponseStrucuture<List<ProductDto>> getAllProductDto()
	{
		return productService.getAllProductDto();
	}
	@DeleteMapping("/deleteProduct")
	public ResponseStrucuture<ProductDto> deleteProductDto(@RequestParam int id)
	{
		return productService.deleteFoodOrderDto(id);
	}
	@PutMapping("/updateProduct")
	public ResponseStrucuture<ProductDto> updateProductDto(@RequestBody ProductDto productDto,
											@RequestParam int id)
	{
		return productService.updateProductDto(id, productDto);
	}

}
