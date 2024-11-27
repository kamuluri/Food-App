package com.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.entities.User;

@Repository
public class Userdao {
	@Autowired
	EntityManagerFactory emf;
	
	public void saveUser(User user) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(user);
		et.commit();
	}
	
	public User viewUserById(int id) {
		EntityManager em=emf.createEntityManager();
		User user =em.find(User.class, id);
		return user;
		
	}
	
	public List<User> viewAllUser(){
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("select u from User u");
		return query.getResultList();
	}
	
	
	public void UpdateUser(User user) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(user);
		et.commit();
	}
	
	public void deleteUserById(int id)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		User u=em.find(User.class, id);
		et.begin();
		em.remove(u);
		et.commit();
	}
	
	public User login(String email,String password) {
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("select a from User a where a.email=?1 and a.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
			List<User> user = query.getResultList();
			if(user.size()>0) return user.get(0);
			else return null;

	}
}

