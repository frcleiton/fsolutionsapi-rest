package br.com.fsolution.ejb.beans;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.google.gson.Gson;

import br.com.fsolution.ejb.dao.CustomerDAO;
import br.com.fsolution.ejb.entities.Customer;
import br.com.fsolution.ejb.interfaces.CustomerLocal;
import br.com.fsolution.ejb.interfaces.CustomerRemote;


@Stateless
@Remote(CustomerRemote.class)
@Local(CustomerLocal.class)
public class CustomerBean implements CustomerRemote, CustomerLocal {
	
	@EJB
	private CustomerDAO dao;
	
	@Override
	public String listAllCustomers() {
		return new Gson().toJson(dao.listAll());
	}

	@Override
	public void createNewCustomer(String name, String phone, String phone2, String address, String number,
			String district, String city, String obs) {
		Customer customer = new Customer();
		customer.setName(name);
		customer.setPhone(phone);
		customer.setPhone2(phone2);
		customer.setAddress(address);
		customer.setAddressnumber(number);
		customer.setDistrict(district);
		customer.setCity(city);
		customer.setObs(obs);
		dao.insert(customer);
	}

}
