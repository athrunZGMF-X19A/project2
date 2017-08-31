package com.revature.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.UserBean;

public class UserDAO {

		private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}
		
		//needs annotations
		
		@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
		public void createUser(UserBean user){
			sessionFactory.getCurrentSession().save(user);
		}
		@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
		public void updateUser(UserBean user){
			sessionFactory.getCurrentSession().saveOrUpdate(user);
		}
		
		@SuppressWarnings("unchecked")
		@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
		public List<UserBean> getUsers(){
			return sessionFactory.getCurrentSession().createQuery("FROM UserBean").list();
		}
		@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
		public void deleteUser(UserBean	user){
			sessionFactory.getCurrentSession().delete(user);
		}
}
