package br.com.fsolution.rest.api;

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
	@Path("/order/all")
	@Produces(MediaType.APPLICATION_JSON)
	String listAllOrders();
	
	@GET
	@Path("/order/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	String getOrderById(@PathParam("id") int id);
	
	@POST
	@Path("/order/add")
	@Produces(MediaType.APPLICATION_JSON)
	Response saveNewOrder(@FormParam("description") String description, 
			              @FormParam("customer_id") int customer_id,
			              @FormParam("obs") String obs,
			              @FormParam("date_expected") String date_expected
			              );
	
	@PUT
	@Path("/order/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	String updateOrder(@PathParam("id") int id, @FormParam("description") String description);
	
	@DELETE
	@Path("/order/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	String deleteOrder(@PathParam("id") int id);
	
}
