package controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import beans.BookBean;
import daos.BookDAO;


@Controller
@RequestMapping(value="/beans/UserBean")
public class BookController {
	
	@Autowired
	private BookDAO dao;

	public void setDao(BookDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="beans/BookBean/createBook", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void createBook(@Valid @RequestBody BookBean book){
		dao.createBook(book);
	}
	@RequestMapping(value="beans/BookBean/updateBook", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateBook(BookBean book){
		dao.updateBook(book);
	}
	@RequestMapping(value="beans/BookBean/getAllBooks", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<BookBean> getAllBooks(){
		return dao.getAllBooks();
	}
	@RequestMapping(value="beans/BookBean/deleteBook", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void deleteBook(BookBean book){
		dao.deleteBook(book);
	}
	
}
