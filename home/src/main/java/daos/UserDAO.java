package daos;

import java.util.List;

import org.hibernate.SessionFactory;

import beans.UserBean;

public class UserDAO {

		private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}
		
		//needs annotations
		
		
		public void createUser(UserBean user){
			sessionFactory.getCurrentSession().save(user);
		}
		
		public void updateUser(UserBean user){
			sessionFactory.getCurrentSession().saveOrUpdate(user);
		}
		
		@SuppressWarnings("unchecked")
		public List<UserBean> getUsers(){
			return sessionFactory.getCurrentSession().createQuery("FROM UserBean").list();
		}
		
		public void deleteUser(UserBean	user){
			sessionFactory.getCurrentSession().delete(user);
		}
}
