package br.com.fsolution.rest.api;

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
	
	@GET
	@Path("/order/all")
	@Produces(MediaType.APPLICATION_JSON)
	String[] listAllOrders();
	
	@POST
	@Path("/order/add")
	@Produces(MediaType.APPLICATION_JSON)
	Response saveNewOrder(@FormParam("description") String description);
	
	@PUT
	@Path("/order/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	String updateOrder(@PathParam("id") int id, @FormParam("description") String description);
	
}
