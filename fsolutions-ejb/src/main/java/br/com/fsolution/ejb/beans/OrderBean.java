package br.com.fsolution.ejb.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ws.rs.WebApplicationException;

import com.google.gson.Gson;

import br.com.fsolution.ejb.dao.OrderDAO;
import br.com.fsolution.ejb.entities.Order;
import br.com.fsolution.ejb.interfaces.OrderLocal;
import br.com.fsolution.ejb.interfaces.OrderRemote;


@Stateless
@Remote(OrderRemote.class)
@Local(OrderLocal.class)
public class OrderBean implements OrderRemote, OrderLocal {
	
	private SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd" );

	@EJB
	private OrderDAO dao;
	
	@Override
	public String listAllOrders() {
		return new Gson().toJson(dao.listAll());
	}

	@Override
	public void updateOrder(int idOrder, String descriptionOrder) {
		dao.update(idOrder, descriptionOrder);			
	}

	@Override
	public String getOrderById(int id) {
		return new Gson().toJson(dao.getOrderById(id));
	}

	@Override
	public void createNewOrder(String descOrder, int custId, String obsOrder, String dateExpOrder) {
		Order order = new Order();
		order.setDescription(descOrder);
		order.setOrder_time(new Date());
		order.setCustomer_id(custId);
		order.setObs(obsOrder);
        try {
            Date date = df.parse(dateExpOrder);
            order.setExpected(date);
        } catch ( final ParseException ex ) {
            throw new WebApplicationException( ex );
        }
		dao.insert(order);
	}

	@Override
	public void deleteOrder(int idOrder) {
		dao.remove(idOrder);		
	}

	@Override
	public void createNewOrder(br.com.fsolution.rest.common.Order _order) {
		Order order = new Order();
		order.setDescription(_order.getDescription());
		order.setCustomer_id(_order.getCustomer_id());
		order.setOrder_time(new Date());
		dao.insert(order);
	}

}
