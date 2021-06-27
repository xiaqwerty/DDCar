package com.example.ddcar.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders")
@Data
public class Order implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @ManyToOne(targetEntity=Driver.class, fetch=FetchType.EAGER)
    @JoinColumn(name="driver_id", referencedColumnName=("id"))
    private Driver driver;
    @ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
    @JoinColumn(name="user_id", referencedColumnName=("id"))
    private User user;
    private String content;
    private String comment;
    public Order(){}
}
