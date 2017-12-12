package br.com.fsolution.rest.impl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;

import br.com.fsolution.ejb.interfaces.Customer;
import br.com.fsolution.ejb.interfaces.Order;
import br.com.fsolution.rest.api.FSolutionService;


@RequestScoped
public class FSolutionServiceImpl implements FSolutionService{

	@EJB(mappedName="java:app/fsolutions-ejb-0.1-SNAPSHOT/OrderBean!br.com.fsolution.ejb.interfaces.OrderRemote")
	private Order order;
	@EJB(mappedName="java:app/fsolutions-ejb-0.1-SNAPSHOT/CustomerBean!br.com.fsolution.ejb.interfaces.CustomerRemote")
	private Customer customer;
	
		
	@Override
	public String listAllOrders() {
		return order.listAllOrders();
	}
	
	@Override
	public String updateOrder(int id, String description) {
		order.updateOrder(id, description);
		return "{\"Message\": \"Success\"}";
	}

	@Override
	public String getOrderById(int id) {
		return order.getOrderById(id);
	}

	@Override
	public Response saveNewOrder(String description, int customer_id, String obs, String date_expected) {
		order.createNewOrder(description, customer_id, obs, date_expected);
		return Response.status(Response.Status.CREATED).build();
	}

	@Override
	public String deleteOrder(int id) {
		order.deleteOrder(id);
		return "{\"Message\": \"Success\"}";
	}

	@Override
	public Response saveNewCustomer(String name, String phone, String phone2, String address, String addressnumber,
			String district, String city, String obs) {
		customer.createNewCustomer(name, phone, phone2, address, addressnumber, district, city, obs);
		return Response.status(Response.Status.CREATED).build();
	}

	@Override
	public String listAllCustomers() {
		return customer.listAllCustomers();
	}

}
