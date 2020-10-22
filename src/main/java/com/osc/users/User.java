package com.osc.users;

import java.util.List;

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

    // need default constructor for JSON Parsing
    public User() {
    }

    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    @OneToMany
    @JoinColumn(name = "userId")
    private List<ShippingInfo> shippinginfolist;

    @OneToMany
    @JoinColumn(name = "userId")
    private List<Order> orderlist;

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

    public String orElse(String username) {
        return null;
    }
}