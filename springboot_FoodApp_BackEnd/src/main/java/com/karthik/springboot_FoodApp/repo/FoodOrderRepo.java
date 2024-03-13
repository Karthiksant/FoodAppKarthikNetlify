package com.karthik.springboot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthik.springboot_FoodApp.dto.FoodOrderDto;

public interface FoodOrderRepo extends JpaRepository<FoodOrderDto,Integer>
{

}
