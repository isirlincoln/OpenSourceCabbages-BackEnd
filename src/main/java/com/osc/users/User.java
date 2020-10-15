package com.osc.users;

import javax.persistence.*;

import com.osc.orders.Order;
import com.osc.shippinginfo.ShippingInfo;



@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    
    private Integer id;
    private String username;
    private String password;
    private boolean admin;
    private boolean supplier;
    private boolean deleted;
    @ManyToMany(targetEntity = Order.class)
    @JoinColumn(name = "orderId")
    private int orderId;
    @ManyToMany(targetEntity = ShippingInfo.class)
	@JoinColumn(name = "shippinginfoId")
	private int shippinginfoId;
    private String orderlist;
    private String shippinginfolist;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isSupplier() {
        return supplier;
    }

    public void setSupplier(boolean supplier) {
        this.supplier = supplier;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
		this.deleted = deleted;
    }
    public String getOrderlist() {
        return orderlist;
    }
    public void setOrderlist(String orderlist) {
        this.orderlist = orderlist;
    }
    public String getShippingInfolist() {
		return shippinginfolist;
	}

    public void setShippingInfolist(String shippinginfolist) {
        this.shippinginfolist = shippinginfolist;
	}
}