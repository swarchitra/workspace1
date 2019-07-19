package com.visa.training.jpa.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import com.visa.training.jpa.domain.*;

public class AccountDAO {
	public Account save(Account obj){
		EntityManagerFactory emf = JpaUtil.getEmf();
		EntityManager em = emf.createEntityManager();
		try{
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(obj); // all write operations should be enclosed within a transaction
			tx.commit();
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		finally {
			em.close();
		}
		return obj;
	}
	public Account findById(int id) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		Account obj = null;
		try{
			obj = em.find(Account.class,id); 
			return obj;
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		finally {
			em.close();
		}
		return obj;
	}
	
	public void update(Account obj) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try{
			
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.merge(obj);
			tx.commit();
			
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	public void delete(Account obj) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try{
			
			Account delete_obj = em.find(Account.class,obj.getId()); 
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.remove(delete_obj);
			tx.commit();
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
	
}
