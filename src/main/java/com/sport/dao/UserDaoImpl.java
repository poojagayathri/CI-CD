package com.sport.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sport.dto.ProductDTO;
import com.sport.entity.Category;
import com.sport.entity.Product;
import com.sport.entity.Users;
import com.sport.repository.*;

@Service
public class UserDaoImpl implements UserDao{
	@Autowired
	UsersRepo userRepo;
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	CategoryRepo catRepo;

	@Override
	public boolean login(String email,String password) {
		System.out.println(email+" "+password);
		List<Users> count=userRepo.findByEmail(email,password);
		System.out.println(count.size()+" is the size");
		
		if( count.size()>=1)
				return true;
		else
			return false;
	}

	@Override
	public List<Users> allUserList() {
		List<Users> users=new ArrayList<>();
		try {
			users= userRepo.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public List<ProductDTO> allProductList() {
		return productRepo.productDet();
	}

	@Override
	public List<Category> allCategory() {
		return catRepo.findAll();
	}

	@Override
	public List<Product> allProducts() {
		return productRepo.findAll(Sort.by(Sort.Direction.DESC,"id"));
	}

	@Override
	public void saveProduct(Product prod) {
		productRepo.save(prod);
		
	}

	@Override
	public int getCategoryId(String name) {
		int id=catRepo.getCategoryId(name);
		return 0;
	}

	@Override
	public void saveCategory(Category cat) {
		catRepo.save(cat);
		
	}
	
	

}
