package com.example.ddcar.service;

import com.example.ddcar.common.result.ResponseData;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

public interface LoginService
{
    ResponseData userLogin(String phoneNumber, String password, HttpServletRequest req);
    ResponseData driverLogin(String phoneNumber, String password, HttpServletRequest req);
}
