package com.revature.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.revature.beans.UserBean;
import com.revature.daos.UserDAO;

public class UserDAOTest {
	
private static ApplicationContext context;
	UserDAO dao = context.getBean(UserDAO.class);
	UserBean user = new UserBean();
	@BeforeClass
	public static void initialize(){
		context = new ClassPathXmlApplicationContext("beans.xml");
	}

	@Test
	public void DAOTest(){
		UserDAO dao = context.getBean(UserDAO.class);
	}
	@Test
	public void createTest(){
		user.setNumberOfBooks(99);
		user.setUsername("KillMe");
		dao.createUser(user);
	}
	@Test
	public void deleteTest(){
		user.setId(dao.getUsers().get(dao.getUsers().size() - 1).getId());
		user.setNumberOfBooks(99);
		user.setUsername("KillMe");
		dao.deleteUser(user);
	}
	@Test
	public void getAllTest(){
		System.out.println(dao.getUsers().get(1).getUsername());
	}
}
