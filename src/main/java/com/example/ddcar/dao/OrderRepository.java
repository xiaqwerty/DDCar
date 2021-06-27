package com.example.ddcar.dao;

import com.example.ddcar.entity.Driver;
import com.example.ddcar.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long>
{
    Order findById(long id);
    List<Order> findOrderByDriver(Driver driver);
}
