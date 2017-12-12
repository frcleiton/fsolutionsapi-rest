package br.com.fsolution.ejb.interfaces;

public interface Customer {
	
	void createNewCustomer(String name, String phone, String phone2, String address, String number,
			String district, String city, String obs);
	
	String listAllCustomers();

}
