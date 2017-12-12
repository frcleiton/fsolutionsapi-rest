package br.com.fsolution.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fsolution.ejb.entities.Customer;
import br.com.fsolution.ejb.entities.Order;

@Stateless
public class CustomerDAO {
	
	@PersistenceContext(unitName = "fsolutions")
	private EntityManager em;
	
	public void insert(Customer customer) {
		em.persist(customer);
	}
	
	public List<Order> listAll() {
		return em.createQuery("from customers s", Order.class).getResultList();
	}
	
}
