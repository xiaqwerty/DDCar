package com.example.ddcar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.example.ddcar.entity.Order;
import org.springframework.context.annotation.Lazy;

@Data
@Entity
@Lazy(value = false)
public class Driver implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;
    private String phoneNumber;
    private String email;
    private String car;
    private double grade;
    private String location;
    @JsonIgnore
    @OneToMany(fetch=FetchType.EAGER,mappedBy="driver")
    //@JoinColumn(name="driver_id")

    List<Order> orders;

    public Driver(String username, String password)
    {
        this.name=username;
        this.password=password;
    }

    public Driver()
    {    }
}
