package com.osc.orders;

import java.util.List;

import javax.persistence.*;

import com.osc.product.Product;



@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;
    private Integer qty;
	private Double totalPrice;
	private Integer userId;
	
	@OneToMany
    @JoinColumn(name = "userId")
    private List <Product> productlist;
	
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
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	};
}