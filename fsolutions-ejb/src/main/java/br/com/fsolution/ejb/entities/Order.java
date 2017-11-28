package br.com.fsolution.ejb.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "service_orders")
@SequenceGenerator(name = "seq_service_orders", sequenceName = "seq_service_orders", allocationSize = 1)

public class Order {

	@Id
	@GeneratedValue(generator = "seq_service_orders", strategy = GenerationType.SEQUENCE)
	private Integer Id;

	private String description;
	
	@Column(name="order_time", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date order_time;

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
	
	
	
}
