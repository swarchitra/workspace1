package com.visa.training.bootproject.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.visa.training.bootproject.domain.Product;

@Repository //<-- DAO
@Transactional //<-- in this bean, spring should take care of transaction
public class ProductDAOJpaImpl implements ProductDAO{

	//dependency inject the entity manager
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Product save(Product p) {
		// no need to create Em or transaction
		em.persist(p);
		return p;
	}

	@Override
	public Product findById(int id) {
		return em.find(Product.class, id);
		
	}

	@Override
	public List<Product> findAll() {
		return em.createQuery("select p from Product as p").getResultList();
	}

	@Override
	public void update(Product p) {
		em.merge(p);
	}

	@Override
	public void remove(int id) {
		Product p = findById(id);
		// here returned p is not detached but persistent
		em.remove(p);
	}
	

}
