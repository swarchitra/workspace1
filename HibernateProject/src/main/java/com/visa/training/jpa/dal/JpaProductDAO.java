package com.visa.training.jpa.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.visa.training.jpa.domain.Product;

public class JpaProductDAO {
	
	
	// all transactions are not auto commit as jdbc
	// Hence all operations are enclosed as one transaction
	
	public Product save(Product obj){
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
	
	public Product findById(int id) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		Product obj = new Product();
		try{
			obj = em.find(Product.class,id); 
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		finally {
			em.close();
		}
		return obj;
	}
	
	
	public List<Product> findAll(){
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		
		//query in JPQL  (JPQL returns objects as results not resultset as MYSQL
		// * --> objects aliases (p)
		//from ---> class name
		// class name and fields are case sensitive
		Query q = em.createQuery(" select p from Product as p");
		// to exceute the query
		List<Product> all = q.getResultList();
		em.close();
		return all;
				
	}
	
	public List<Product> findByPriceGreaterThan(float price){
		 EntityManager em = JpaUtil.getEmf().createEntityManager();
		
		//query in JPQL  (JPQL returns objects as results not resultset as MYSQL
		// * --> objects aliases (p)
		//from ---> class name
		// where --> where
		//class name and fields are case sensitive
		// use field name not column name
		Query q = em.createQuery(" select p from Product as p where p.price > :priceParam");
		q.setParameter("priceParam", price);
		// to exceute the query
		List<Product> all = q.getResultList();
		em.close();
		return all;
	}
	
	public void update(Product obj) {
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
	public void delete(Product obj) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try{
			
			Product delete_obj = em.find(Product.class,obj.getId()); 
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
