package com.osc.orders;

import javax.persistence.*;

import com.osc.users.User;
import com.osc.shippinginfo.ShippingInfo;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;
    private Integer qty;
	private Double totalPrice;
	@OneToOne(targetEntity = User.class)
	@JoinColumn(name = "userId")
	private int userId;
	private String shippinginfolist;
	private String userlist;
	@OneToOne(targetEntity = ShippingInfo.class)
	@JoinColumn(name = "shippinginfoId")
	private int shippinginfoId;
    
	
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
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
   
	public String getUserlist() {
        return userlist;
	}

    public void setUserlist(String userlist) {
        this.userlist = userlist;
	}
	public String getShippingInfolist() {
		return shippinginfolist;
	}

    public void setShippingInfolist(String shippinginfolist) {
        this.shippinginfolist = shippinginfolist;
	}

	@Override 
	public String toString() {
		return "Order{" + "id=" + this.id +  ", Customer ID:" + getUserId() + '}'; 
	} 
}