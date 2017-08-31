package com.revature.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.revature.beans.UserBean;
import com.revature.controllers.UserController;
import com.revature.daos.UserDAO;

public class UserControllerTest {
	private static ApplicationContext context;
	UserController uc = new UserController(); 
	UserBean user = new UserBean();
	UserDAO dao = context.getBean(UserDAO.class);
	
	@BeforeClass
	public static void initialize(){
		context = new ClassPathXmlApplicationContext("beans.xml");
	}
	@Test
	public void createTest(){
		uc.setDao(dao);
		user.setId(50);
		user.setNumberOfBooks(99);
		user.setUsername("killme");
		uc.createUser(user);
	}
	@Test
	public void deleteTest(){
		uc.setDao(dao);
		user.setId(dao.getUsers().get(dao.getUsers().size() - 1).getId());
		user.setNumberOfBooks(99);
		user.setUsername("KillMe");
		uc.deleteUser(user);
	}
	@Test
	public void getAllTest(){
		uc.setDao(dao);
		System.out.println(uc.getUsers().get(1).getUsername());
	}
}
