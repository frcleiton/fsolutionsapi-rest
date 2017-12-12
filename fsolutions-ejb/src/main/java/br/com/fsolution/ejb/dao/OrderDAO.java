package br.com.fsolution.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fsolution.ejb.entities.Order;

@Stateless
public class OrderDAO {
	
	@PersistenceContext(unitName = "fsolutions")
	private EntityManager em;
	
	public void insert(Order order) {
		em.persist(order);
	}
	
	public List<Order> listAll() {
		return em.createQuery("from service_orders s", Order.class).getResultList();
	}
	
	public void update(int id, String descriptionOrder) {
		Order order = em.find(Order.class, id);
		order.setDescription(descriptionOrder);
		em.merge(order);
	}
	
	public Order getOrderById(int id) {
		return em.find(Order.class, id);
	}
	
	public void remove(int id) {
		em.remove(em.find(Order.class, id));
	}
}
