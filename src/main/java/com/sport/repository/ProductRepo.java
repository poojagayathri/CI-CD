package com.sport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sport.dto.ProductDTO;
import com.sport.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {
	
	@Query("select new com.sport.dto.ProductDTO(p.id,p.productName,p.imgpath,c.categoryName,p.price,p.quantity) from Product p, Category c where c.id=p.id")
	List<ProductDTO> productDet();

}
