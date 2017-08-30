package com.revature.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.BookBean;

public class BookDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//needs annotations
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void createBook(BookBean book){
		sessionFactory.getCurrentSession().save(book);
	}
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void updateBook(BookBean book){
		sessionFactory.getCurrentSession().saveOrUpdate(book);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public List<BookBean> getAllBooks(){
		return sessionFactory.getCurrentSession().createQuery("FROM BookBean").list();
	}
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void deleteBook(BookBean book){
		sessionFactory.getCurrentSession().delete(book);
	}

}
