package com.example.ddcar.controller;

import com.example.ddcar.dao.*;
import com.example.ddcar.entity.Driver;
import com.example.ddcar.entity.User;
import com.example.ddcar.common.result.ExceptionMsg;
import com.example.ddcar.common.result.ResponseData;
import com.example.ddcar.service.CaptchaService;
import com.example.ddcar.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class RegisterController
{

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private LoginService loginService;

    @RequestMapping("/user/register")
    public ResponseData registerUser(@RequestParam String username, @RequestParam String password,
                                     @RequestParam String phoneNumber,@RequestParam String code)
    {
        if(userRepository.findByPhoneNumber(phoneNumber)!=null)
            return new ResponseData(ExceptionMsg.FAILED,"手机号已被注册");
        else
        if (code .equals ((String) redisTemplate.opsForValue().get(phoneNumber)))
        {
            User user=new User(username,password);
            user.setPhoneNumber(phoneNumber);
            userRepository.save(user);
            //return "login";
            return new ResponseData(ExceptionMsg.SUCCESS,user);
        }
        return new ResponseData(ExceptionMsg.FAILED,code);
    }

    @RequestMapping("/driver/register")
    public ResponseData registerDriver(@RequestParam String username, @RequestParam String password,
                                       @RequestParam String phoneNumber,@RequestParam String code)
    {
        if(driverRepository.findByPhoneNumber(phoneNumber)!=null)
            return new ResponseData(ExceptionMsg.FAILED,"手机号已被注册");
        else
        if (code .equals ((String) redisTemplate.opsForValue().get(phoneNumber)))
        {
            Driver driver=new Driver(username,password);
            driver.setPhoneNumber(phoneNumber);
            driverRepository.save(driver);
            //return "login";
            return new ResponseData(ExceptionMsg.SUCCESS,driver);
        }
        return new ResponseData(ExceptionMsg.FAILED,code);
    }

    @Operation(description = "点击发送验证码")
    @RequestMapping("/register/verification-code")
    public void verificationCode(@RequestParam String phoneNumber)
    {
        String code=captchaService.getCaptcha(phoneNumber);
        System.out.println(code);
    }


    @RequestMapping("/user/login")
    public ResponseData userLogin(@RequestParam String phoneNumber, @RequestParam String password, HttpServletRequest req)
    {
        ResponseData response=loginService.userLogin(phoneNumber,password,req);
        if(response.getRspCode().equals("200"))
            return new ResponseData(ExceptionMsg.SUCCESS,"这里应该是登陆后页面");
        else
            return new ResponseData(ExceptionMsg.FAILED,response.getRspMsg());
    }

    @RequestMapping("/driver/login")
    public ResponseData driverLogin(@RequestParam String phoneNumber, @RequestParam String password, HttpServletRequest req)
    {
        ResponseData response=loginService.driverLogin(phoneNumber,password,req);
        if(response.getRspCode().equals("200"))
            return new ResponseData(ExceptionMsg.SUCCESS,"这里应该是登陆后页面");
        else
            return new ResponseData(ExceptionMsg.FAILED,response.getRspMsg());
    }




    @GetMapping("/driver/get-user/{id}")
    public ResponseData getDriver(@PathVariable long id)
    {
        Driver driver=driverRepository.findById(id);
        return new ResponseData(ExceptionMsg.SUCCESS,driver);
    }

    @GetMapping("/user/show")
    public ResponseData showUser()
    {
        List userList=userRepository.findAll();
        return new ResponseData(ExceptionMsg.SUCCESS,userList);
    }
}
