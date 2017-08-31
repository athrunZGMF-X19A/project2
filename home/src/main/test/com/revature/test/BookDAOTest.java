package com.revature.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.BookBean;

import com.revature.daos.BookDAO;


public class BookDAOTest {
	
	private static ApplicationContext context;
	BookDAO dao= context.getBean(BookDAO.class);; 
	BookBean book = new BookBean();
	@BeforeClass
	public static void initialize(){
		context = new ClassPathXmlApplicationContext("beans.xml");
	}

	@Test
	public void DAOTest(){
		BookDAO dao = context.getBean(BookDAO.class);
	}
	@Test
	public void createTest(){
		book.setAuthor("test");
		book.setDescription("test");
		book.setGenre("test");
		book.setTitle("test");
		book.setQuantity(1);
		dao.createBook(book);
	}
	@Test
	public void deleteTest(){
		book.setD3Id(dao.getAllBooks().get(dao.getAllBooks().size() - 1).getD3Id());
		book.setAuthor("test");
		book.setDescription("test");
		book.setGenre("test");
		book.setTitle("test");
		book.setQuantity(1);
		dao.deleteBook(book);
	}
	@Test
	public void getAllTest(){
		System.out.println(dao.getAllBooks().get(3).getTitle());
	}
}
