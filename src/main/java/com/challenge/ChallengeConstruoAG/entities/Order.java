package com.challenge.ChallengeConstruoAG.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "O_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private long time;

    public Order() {

    }

    public Order(Integer id, long time) {
        this.id = id;
        this.time = time;
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
