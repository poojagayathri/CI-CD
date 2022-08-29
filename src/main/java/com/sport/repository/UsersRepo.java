package com.sport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sport.entity.Users;

public interface UsersRepo extends JpaRepository<Users,Integer> {
	
	@Query("select u from Users u where u.email= :email and u.password=:password ")
	List<Users> findByEmail(@Param("email")String email,@Param("password") String password);

}
