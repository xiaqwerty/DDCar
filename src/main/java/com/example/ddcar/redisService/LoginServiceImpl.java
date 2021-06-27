package com.example.ddcar.redisService;

import com.example.ddcar.common.result.ExceptionMsg;
import com.example.ddcar.common.result.ResponseData;
import com.example.ddcar.dao.DriverRepository;
import com.example.ddcar.dao.UserRepository;
import com.example.ddcar.entity.Driver;
import com.example.ddcar.entity.User;
import com.example.ddcar.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    DriverRepository driverRepository;

    @Override
    public ResponseData userLogin(String phoneNumber, String password, HttpServletRequest req)
    {
        User user=userRepository.findByPhoneNumber(phoneNumber);
        HttpSession session=req.getSession();
        if(user!=null)
        {
            if(password.equals(user.getPassword()))
            {
                session.setAttribute("userId", user.getId());
                return new ResponseData(ExceptionMsg.SUCCESS,"登陆成功");
            }
            else return new ResponseData(ExceptionMsg.FAILED,"密码错误！");
        }
        else return new ResponseData(ExceptionMsg.FAILED,"用户不存在！");
    }

    @Override
    public ResponseData driverLogin(String phoneNumber, String password, HttpServletRequest req)
    {
        Driver driver=driverRepository.findByPhoneNumber(phoneNumber);
        HttpSession session=req.getSession();
        if(driver!=null)
        {
            if(password.equals(driver.getPassword()))
            {
                session.setAttribute("driverId", driver.getId());
                return new ResponseData(ExceptionMsg.SUCCESS,"登陆成功");
            }
            else return new ResponseData(ExceptionMsg.FAILED,"密码错误！");
        }
        else return new ResponseData(ExceptionMsg.FAILED,"用户不存在！");
    }
}
