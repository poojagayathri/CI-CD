package com.sport.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sport.dao.UserDao;
import com.sport.dto.ProductDTO;
import com.sport.entity.*;

@Controller
public class AppController {
	
	@Autowired
	UserDao dao;
	
	@RequestMapping("/")
	public String start(Model model) {
		System.out.println("entere here");
		model.addAttribute("user",new Users());
		return "Login";
	}
	
	@RequestMapping("login") 
	public String login(@ModelAttribute("user") Users user,Model model,HttpServletRequest request) { 
		System.out.println(user.getEmail()+" "+user.getPassword()); 
		boolean userExist=dao.login(user.getEmail(), user.getPassword());
		if(userExist)
		{
			HttpSession session=request.getSession();
			session.setAttribute("name", user.getEmail());
			model.addAttribute("users",dao.allUserList());
			return "redirect:userList";
		}
		else
		{
			model.addAttribute("msg","Wrong password");
			return "login";
		}
				
	}
	
	
	@RequestMapping("userList") 
	public String userList(Model model,HttpServletRequest request) {
		model.addAttribute("users",dao.allUserList());
		HttpSession session = request.getSession(false);
		System.out.println(session.getAttribute("name"));
		if(session!=null)
			System.out.println("not null");
		else
			System.out.println("null");
		return "UserList";
	}
	
	@RequestMapping("productList") 
	public String productList(Model model) {
		model.addAttribute("productDto",dao.allProductList());
		return "ProductList";
	}
	
	@RequestMapping("getShoePhoto")
	public void getStudentPhoto(HttpServletResponse response, HttpServletRequest request) throws Exception {
		String id=request.getParameter("id");
		String url="C:\\Users\\pooja gayathri p v\\Desktop\\Simplilearn\\SportyShoes\\ShoesImg\\shoe-";
		url=url+id+".png";
		System.out.println(url);
		File imageFile = new File(url);
        response.setContentType("image/png");
        InputStream in=new FileInputStream(imageFile);
        IOUtils.copy(in, response.getOutputStream());
	}
	
	@RequestMapping("newProductRedirect")
	public String addNewProductRedirect(Model model) {
		List<Category> catList=dao.allCategory();
		List<String> list=catList.stream().map(Category::getCategoryName).collect(Collectors.toList());
		model.addAttribute("catList",list);
		return "NewProduct";
	}
	
	@RequestMapping("newProduct")
	public String newProduct(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
		String name=request.getParameter("productName");
		int price=Integer.parseInt(request.getParameter("price"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		String catName=request.getParameter("categoryName");
		int catId=dao.getCategoryId(catName);
		Product prod=new Product();
		prod.setCategoryId(catId);
		prod.setPrice(price);
		prod.setProductName(name);
		prod.setQuantity(quantity);
		System.out.println("heloo");
		if (file.isEmpty()) {
			System.out.println("Please select a file and try again");
		}

		//check commit and pipeline
		try {
			int id=0;
			if(dao.allProducts().size()!=0)
				id=dao.allProducts().get(0).getId();
			id=id+1;
			byte[] bytes = file.getBytes();
			Path path = Paths.get(id+".png");
			Files.write(path, bytes);
			dao.saveProduct(prod);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "ProductList";

	}
	
	@RequestMapping("categoryList")
	public String categoryList(Model model) {
		model.addAttribute("Category", dao.allCategory());
		return "CategoryList";
	}
	
	@RequestMapping("newCatRedirect")
	public String newCatRedirect(Model model) {
		model.addAttribute("category",new Category());
		return "NewCategory";
	}
	
	@RequestMapping("newCategory")
	public String newCategory(@ModelAttribute("category") Category cat ) {
		dao.saveCategory(cat);
		return "CategoryList";
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		session.invalidate();
		return "redirect:/";
	}
	
	 

}
