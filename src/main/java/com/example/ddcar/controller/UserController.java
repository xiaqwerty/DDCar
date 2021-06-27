package com.example.ddcar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController
{
    @Operation(description = "主页")
    @RequestMapping("/")
    public String index(HttpServletRequest request)
    {
        if(request.getSession().getAttribute("login").equals(true))
            return "index";
        else return "login";
    }

    @Operation(description = "个人简介")
    @RequestMapping("/info")
    public String userInfo(){return "";}

    @Operation(description = "叫车")
    @PostMapping("/call")
    public void callCar()
    {

    }

    @Operation(description = "确认接单信息")//司机接单-用户确认
    @RequestMapping("/confirm")
    public void confirmOrder(){};

    @Operation(description = "支付")
    @PostMapping("/pay")
    public void pay() {

    }

    @Operation(description = "查看订单")
    @GetMapping("/get-order")
    public void getOrder() {

    }

    @Operation(description = "查看司机信息")
    @GetMapping("/driver-info")
    public void getDriverInfo() {

    }

    @Operation(description = "评价")
    @PostMapping("/comment")
    public void comment() {

    }
}
