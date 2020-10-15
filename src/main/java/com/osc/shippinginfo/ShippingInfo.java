package com.osc.shippinginfo;

import javax.persistence.*;

import com.osc.users.User;
import com.osc.orders.Order;

@Entity
@Table(name = "shippingInfo")
public class ShippingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String address;
    private String city;
    private String state;
    private int zipcode;
	private String country;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "userId")
	private int userId;
	@OneToOne(targetEntity = Order.class)
	@JoinColumn(name = "orderId")
	private int orderId;
	
	private String orderlist;
    private String userlist;
    

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUserlist() {
        return userlist;
	}

    public void setUserlist(String userlist) {
        this.userlist = userlist;
	}

	public String getOrderlist() {
        return orderlist;
	}

    public void setOrderlist(String orderlist) {
        this.orderlist = orderlist;
    }

}