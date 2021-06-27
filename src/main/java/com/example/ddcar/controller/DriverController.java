package com.example.ddcar.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/driver")
public class DriverController
{
    @Operation(description = "主页")
    @RequestMapping("/")
    public String index(){return "index";}

    @Operation(description = "开始接单")//展示在一定距离内的乘客订单
    @GetMapping("/get-orders")
    public void getOrders() {}

    @Operation(description = "结束接单")//展示在一定距离内的乘客订单
    @GetMapping("/stop-get-orders")
    public void stopGettingOrders() {}

    @Operation(description = "接单")
    @PostMapping("/take-order/{id}")
    public void takeOrder(@RequestParam long orderId){}

    @Operation(description = "开车")
    @GetMapping("/order/start")
    public void startDriving(){};

    @Operation(description = "结束行程")//提交相关计费信息，用户进入支付
    @GetMapping("/order/stop")
    public void stopDriving(){};

}
