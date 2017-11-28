package br.com.fsolution.ejb.interfaces;

public interface Order {
	
	void createNewOrder(String descriptionOrder);
	
	void updateOrder(int idOrder, String descriptionOrder);
	
	String[] listAllOrders();
	
}
