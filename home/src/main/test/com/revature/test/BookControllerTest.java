package com.revature.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.BookBean;
import com.revature.beans.UserBean;
import com.revature.controllers.BookController;
import com.revature.controllers.UserController;
import com.revature.daos.BookDAO;
import com.revature.daos.UserDAO;

public class BookControllerTest {
	private static ApplicationContext context;
	BookController bc = new BookController(); 
	BookBean book = new BookBean();
	BookDAO dao = context.getBean(BookDAO.class);
	
	@BeforeClass
	public static void initialize(){
		context = new ClassPathXmlApplicationContext("beans.xml");
	}
	@Test
	public void createTest(){
		bc.setDao(dao);
		book.setAuthor("test");
		book.setDescription("test");
		book.setGenre("test");
		book.setTitle("test");
		book.setQuantity(1);
		bc.createBook(book);
	}
	@Test
	public void deleteTest(){
		bc.setDao(dao);
		book.setD3Id(dao.getAllBooks().get(dao.getAllBooks().size() - 1).getD3Id());
		book.setAuthor("test");
		book.setDescription("test");
		book.setGenre("test");
		book.setTitle("test");
		book.setQuantity(1);
		bc.deleteBook(book);
	}
	@Test
	public void getAllTest(){
		bc.setDao(dao);
		System.out.println(bc.getAllBooks().get(3).getTitle());
	}
}
