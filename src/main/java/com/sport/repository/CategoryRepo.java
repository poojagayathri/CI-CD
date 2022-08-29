package com.sport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sport.entity.Category;
import com.sport.entity.Users;

public interface CategoryRepo extends JpaRepository<Category,Integer>{
	
	@Query("select id from Category where categoryName=:name ")
	int getCategoryId(@Param("name")String name);

}
