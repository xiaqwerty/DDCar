package com.example.ddcar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;
    private String phoneNumber;
    private String email;
    private int points;
    @JsonIgnore
    @OneToMany(fetch=FetchType.EAGER,mappedBy="driver")
    private List<Order> orders;
    public User(String name,String password)
    {
        this.name=name;
        this.password=password;
    }

    public User()
    {    }
}
