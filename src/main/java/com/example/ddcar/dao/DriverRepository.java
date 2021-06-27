package com.example.ddcar.dao;

import com.example.ddcar.entity.Driver;
import com.example.ddcar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver,Long>
{
    Driver findById(long id);
    List<Driver> findAll();
    Driver save(Driver user);
    void deleteById(long id);
    Driver findByPhoneNumber(String phoneNumber);
}