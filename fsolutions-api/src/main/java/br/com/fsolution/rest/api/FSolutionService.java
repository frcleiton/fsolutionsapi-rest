package br.com.fsolution.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fsolution.rest.common.Order;

@Path("/rest")
public interface FSolutionService {
	
	@POST
	@Path("/customer/add")
	@Produces(MediaType.APPLICATION_JSON)
	Response saveNewCustomer(@FormParam("name") String name, 
			              @FormParam("phone") String phone,
			              @FormParam("phone2") String phone2,
			              @FormParam("address") String address,
			              @FormParam("number") String number,
			              @FormParam("district") String district,
			              @FormParam("city") String city,
			              @FormParam("obs") String obs			              
			              );
	
	@GET
	@Path("/customer/all")
	@Produces(MediaType.APPLICATION_JSON)
	String listAllCustomers();
	
	@GET
	@Path("/orders")
	@Produces(MediaType.APPLICATION_JSON)
	String listAllOrders();
	
	@POST
	@Path("/orders/")
	@Consumes(MediaType.APPLICATION_JSON)
	Response saveNewOrder(Order order);

	@GET
	@Path("/orders/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	String getOrderById(@PathParam("id") int id);
	
	@PUT
	@Path("/orders/")
	@Consumes(MediaType.APPLICATION_JSON)
	Response updateOrder(Order order);
	
	@DELETE
	@Path("/orders/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	String deleteOrder(@PathParam("id") int id);
	
}
