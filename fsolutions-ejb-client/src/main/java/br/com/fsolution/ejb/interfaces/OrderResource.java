package br.com.fsolution.ejb.interfaces;

import br.com.fsolution.rest.common.Order;

public interface OrderResource {
	
	void createNewOrder(Order order);
	
	String getOrderById(int id);
	
	void updateOrder(Order order);
	
	void deleteOrder(int idOrder);
	
	String listAllOrders();

}
