package br.com.fsolution.rest.impl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;

import br.com.fsolution.ejb.interfaces.Order;
import br.com.fsolution.rest.api.FSolutionService;


@RequestScoped
public class FSolutionServiceImpl implements FSolutionService{

	@EJB(mappedName="java:app/fsolutions-ejb-0.1-SNAPSHOT/OrderBean!br.com.fsolution.ejb.interfaces.OrderRemote")
	private Order order;
		
	@Override
	public String[] listAllOrders() {
		return order.listAllOrders();
	}
	
	public Response saveNewOrder(String description) {
		order.createNewOrder(description);
		return Response.status(Response.Status.CREATED).build();
	}

	@Override
	public String updateOrder(int id, String description) {
		order.updateOrder(id, description);
		return "{\"Message\": \"Success\"}";
	}
}
