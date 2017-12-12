package br.com.fsolution.ejb.interfaces;

public interface Order {
	
	void createNewOrder(String descOrder, int custId, String obsOrder, String dateExpOrder);
	
	String getOrderById(int id);
	
	void updateOrder(int idOrder, String descriptionOrder);
	
	void deleteOrder(int idOrder);
	
	String listAllOrders();

}
