package com.karthik.springboot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthik.springboot_FoodApp.dto.FoodOrderDto;
import com.karthik.springboot_FoodApp.dto.MenuDto;

public interface MenuRepo extends JpaRepository<MenuDto,Integer>
{

}
