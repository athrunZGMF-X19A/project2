package daos;

import java.util.List;

import org.hibernate.SessionFactory;

import beans.BookBean;

public class BookDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//needs annotations
	
	public void createBook(BookBean book){
		sessionFactory.getCurrentSession().save(book);
	}
	
	public void updateBook(BookBean book){
		sessionFactory.getCurrentSession().saveOrUpdate(book);
	}
	
	@SuppressWarnings("unchecked")
	public List<BookBean> getAllBooks(){
		return sessionFactory.getCurrentSession().createQuery("FROM BookBean").list();
	}
	
	public void deleteBook(BookBean book){
		sessionFactory.getCurrentSession().delete(book);
	}

}
