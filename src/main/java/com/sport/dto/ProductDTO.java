package com.sport.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class ProductDTO {
	private int id;
	private String productName;
	private String imgpath;
	private String categoryName;
	private int price;
	private int quantity;
	public ProductDTO(int id, String productName, String imgpath, String categoryName, int price, int quantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.imgpath = imgpath;
		this.categoryName = categoryName;
		this.price = price;
		this.quantity = quantity;
	}
	public ProductDTO() {
		super();
	}
	
	
	
	

}
