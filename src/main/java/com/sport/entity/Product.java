package com.sport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ProductName")
	private String productName;
	@Column(name="ImgPath")
	private String imgpath;
	@Column(name="CategoryId")
	private int categoryId;
	@Column(name="Price")
	private int price;
	@Column(name="Quantity")
	private int quantity;
	

}
