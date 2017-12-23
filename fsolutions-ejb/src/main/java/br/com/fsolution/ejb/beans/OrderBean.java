package br.com.fsolution.ejb.beans;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.google.gson.Gson;

import br.com.fsolution.ejb.dao.OrderDAO;
import br.com.fsolution.ejb.entities.Customer;
import br.com.fsolution.ejb.entities.Order;
import br.com.fsolution.ejb.interfaces.OrderLocal;
import br.com.fsolution.ejb.interfaces.OrderRemote;


@Stateless
@Remote(OrderRemote.class)
@Local(OrderLocal.class)
public class OrderBean implements OrderRemote, OrderLocal {
	
	@EJB
	private OrderDAO dao;
	
	@Override
	public String listAllOrders() {
		return new Gson().toJson(dao.listAll());
	}

	@Override
	public void updateOrder(br.com.fsolution.rest.common.Order _order) {
		Customer customer = new Customer();
		customer.setId(_order.getCustomer().getId());
		
		Order order = new Order();
		order.setId(_order.getId());
		order.setDescription(_order.getDescription());
		order.setCustomer(customer);
		order.setOrder_time(new Date());
		order.setObs(_order.getObs());
		order.setExpected(_order.getExpected());		
		dao.update(order);			
	}

	@Override
	public String getOrderById(int id) {
		return new Gson().toJson(dao.getOrderById(id));
	}

	@Override
	public void deleteOrder(int idOrder) {
		dao.remove(idOrder);		
	}

	@Override
	public void createNewOrder(br.com.fsolution.rest.common.Order _order) {
		Customer customer = new Customer();
		customer.setId(_order.getCustomer().getId());
		
		Order order = new Order();
		order.setDescription(_order.getDescription());
		order.setCustomer(customer);
		order.setOrder_time(new Date());
		order.setObs(_order.getObs());
		order.setExpected(_order.getExpected());
		dao.insert(order);
	}

}
