package br.com.fsolution.rest.common;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer Id;
	String description;
	private Date order_time;
    private Customer customer;
	private Date completion;
	private Date delivered;
	private String obs;
	private Date expected;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getCompletion() {
		return completion;
	}
	public void setCompletion(Date completion) {
		this.completion = completion;
	}
	public Date getDelivered() {
		return delivered;
	}
	public void setDelivered(Date delivered) {
		this.delivered = delivered;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public Date getExpected() {
		return expected;
	}
	public void setExpected(Date expected) {
		this.expected = expected;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
		
	
}
