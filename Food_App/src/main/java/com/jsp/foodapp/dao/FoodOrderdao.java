
package com.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.entities.FoodOrder;


@Repository
public class FoodOrderdao {
	@Autowired
	EntityManagerFactory emf;
	
	public void saveFoodOrder(FoodOrder fo) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(fo);
		et.commit();
	}
	
	public FoodOrder viewFoodOrderById(int id) {
		EntityManager em=emf.createEntityManager();
		FoodOrder fo =em.find(FoodOrder.class, id);
		return fo;
		
	}
	
	public List<FoodOrder> viewAllFoodOrder(){
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("select u from FoodOrder u");
		return query.getResultList();
	}
	
	
	public void UpdateFoodOrder(FoodOrder fo) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(fo);
		et.commit();
	}
	
	public void deleteFoodorderById(int id)
	{
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		FoodOrder fo=em.find(FoodOrder.class, id);
		et.begin();
		em.remove(fo);
		et.commit();
	}
}
