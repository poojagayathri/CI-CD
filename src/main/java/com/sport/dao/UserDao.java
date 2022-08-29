package com.sport.dao;

import java.util.List;

import com.sport.dto.ProductDTO;
import com.sport.entity.*;

public interface UserDao {
	
	boolean login(String email,String password);
	
	List<Users> allUserList();
	
	List<ProductDTO> allProductList();
	
	List<Product> allProducts();
	
	List<Category> allCategory();
	
	void saveProduct(Product prod);
	
	int getCategoryId(String name);
	
	void saveCategory(Category cat);
	

}
