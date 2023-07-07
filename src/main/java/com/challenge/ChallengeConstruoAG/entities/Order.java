package com.challenge.ChallengeConstruoAG.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "O_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private long time;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "id.order")
    private List<OrderProduct> product = new ArrayList<>();

    public List<OrderProduct> getProduct() {
        return product;
    }

    public void setProduct(List<OrderProduct> product) {
        this.product = product;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Order() {

    }

    public Order(Integer id, long time, User client) {
        this.id = id;
        this.time = time;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
