package com.example.ddcar.controller;

import com.example.ddcar.dao.*;
import com.example.ddcar.entity.Driver;
import com.example.ddcar.entity.Order;
import com.example.ddcar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class test
{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping ("/order/add")
    public void addOrder(@RequestParam long id)
    {
        Order order=new Order();
        User user = userRepository.findById(id);
        order.setUser(user);
        Driver driver = driverRepository.findById(1);
        order.setDriver(driver);
        orderRepository.save(order);
        //orderService.insertOrder(order);
    }
    @RequestMapping("/driver/show")
    public List<Order> show(@RequestParam long id){
            return driverRepository.findById(id).getOrders();
    }
    @RequestMapping("/user-order/show")
    public List<Order> userShow(@RequestParam long id){
        return userRepository.findById(id).getOrders();
    }
}
