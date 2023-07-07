package com.challenge.ChallengeConstruoAG.entities;

import jakarta.persistence.*;

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
