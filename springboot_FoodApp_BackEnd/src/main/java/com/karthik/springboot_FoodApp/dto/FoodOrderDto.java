
package com.karthik.springboot_FoodApp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
//@Data
public class FoodOrderDto 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private long customerPhone;
	private String customerAddress;
	private double customerPrice;

	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemsDto> itemsDtos;
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(long customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public double getCustomerPrice() {
		return customerPrice;
	}

	public void setCustomerPrice(double customerPrice) {
		this.customerPrice = customerPrice;
	}

	public List<ItemsDto> getItemsDtos() {
		return itemsDtos;
	}

	public void setItemsDtos(List<ItemsDto> itemsDtos) {
		this.itemsDtos = itemsDtos;
	}

	@Override
	public String toString() {
		return "FoodOrderDto [customerId=" + customerId + ", customerName=" + customerName + ", customerPhone="
				+ customerPhone + ", customerAddress=" + customerAddress + ", customerPrice=" + customerPrice
				+ ", itemsDtos=" + itemsDtos + "]";
	}
	
}
