package br.com.fsolution.ejb.interfaces;

import br.com.fsolution.rest.common.Order;

public interface OrderResource {
	
	void createNewOrder(String descOrder, int custId, String obsOrder, String dateExpOrder);
	
	void createNewOrder(Order order);
	
	String getOrderById(int id);
	
	void updateOrder(int idOrder, String descriptionOrder);
	
	void deleteOrder(int idOrder);
	
	String listAllOrders();

}
