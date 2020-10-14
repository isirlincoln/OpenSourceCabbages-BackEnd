package com.osc.orders;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;
    private Integer qty;
    private Double totalPrice;
	private Integer supplierId;
	
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
    }
    
    public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
    }
    
    public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
    }

    public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
    }

    public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
    
}