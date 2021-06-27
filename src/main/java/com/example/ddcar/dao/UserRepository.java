package com.example.ddcar.dao;

import com.example.ddcar.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>
{
   // @Query("select t from user t where t.id=?1")
    User findById(long id);
    //@Select("select * from user limit 1000")
    List<User> findAll();
    //@Insert("insert into user(name,password) values(#{name},#{password})")
    User save(User user);
   // @Delete("delete from user where id=#{id}")
    void deleteById(long id);
    User findByPhoneNumber(String phoneNumber);
}