package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.BookBean;
import com.revature.daos.BookDAO;


@Controller
public class BookController {
	
	@Autowired
	private BookDAO dao;

	public void setDao(BookDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/createBook", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void createBook(@Valid @RequestBody BookBean book){
		dao.createBook(book);
	}
	@RequestMapping(value="/updateBook", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void updateBook(@Valid @RequestBody BookBean book){
		dao.updateBook(book);
	}
	
	@RequestMapping(value="/updateBookById/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void updateBookById(@PathVariable("id") int id, @RequestBody BookBean book){
		BookBean currentBook = dao.findBookById(id);
		if(currentBook == null){
			System.out.println("Book Not Found");
		}
		
		currentBook.setTitle(book.getTitle());
		currentBook.setAuthor(book.getAuthor());
		currentBook.setDescription(book.getDescription());
		currentBook.setGenre(book.getGenre());
		currentBook.setQuantity(book.getQuantity());
		
		dao.updateBook(currentBook);
	}
	
	@RequestMapping(value="/getAllBooks", method=RequestMethod.GET, 
			/*consumes=MediaType.APPLICATION_JSON_VALUE,*/ produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<BookBean> getAllBooks(){
		return dao.getAllBooks();
	}
	@RequestMapping(value="/deleteBook", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteBook(@RequestBody BookBean book){
		dao.deleteBook(book);
	}

}
