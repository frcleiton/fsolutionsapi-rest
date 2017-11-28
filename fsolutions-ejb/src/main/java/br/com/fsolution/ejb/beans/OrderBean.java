package br.com.fsolution.ejb.beans;

import java.util.Date;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.fsolution.ejb.dao.OrderDAO;
import br.com.fsolution.ejb.entities.Order;
import br.com.fsolution.ejb.interfaces.OrderLocal;
import br.com.fsolution.ejb.interfaces.OrderRemote;


@Stateless
@Remote(OrderRemote.class)
@Local(OrderLocal.class)
public class OrderBean implements OrderRemote, OrderLocal {

	@EJB
	private OrderDAO dao;
	
	@Override
	public void createNewOrder(String descriptionOrder) {
		Order order = new Order();
		order.setDescription(descriptionOrder);
		order.setOrder_time(new Date());
		dao.insert(order);		
	}

	@Override
	public String[] listAllOrders() {
		return dao.listAll()
				.stream()
				.map(Order::getDescription)
				.collect(Collectors.toList())
				.toArray(new String[0]);
	}

	@Override
	public void updateOrder(int idOrder, String descriptionOrder) {
		dao.update(idOrder, descriptionOrder);			
	}
	
}
