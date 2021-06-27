package com.example.ddcar.redisService;

import com.example.ddcar.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
//@CacheConfig(cacheNames = "captcha")
@Service
public class CaptchaServiceImpl implements CaptchaService
{
    private static String Url = "http://106.ihuyi.com/webservice/sms.php?method=Submit";

    @Autowired
    private RedisService redisService;

    public String getCaptcha(String phoneNumber)
    {
        Random r=new Random();
        String code="";
        for (int i=0;i<6;i++)
        {
            code+=r.nextInt(10);
        }
        code=String.valueOf(Integer.parseInt(code));
        redisService.remove(phoneNumber);     //清除未失效的key对应的value值
        redisService.set(phoneNumber,code);
        redisService.expire(phoneNumber, 3*60);  //设置过期时间   3分钟
        /*StringBuilder url=new StringBuilder();
        url.append("http://106.ihuyi.com/webservice/sms.php?method=Submit&account=C72058701&password=d8c9d54356bc695d2b9b55b098dee673&mobile=");
        url.append(phoneNumber);
        String content = new String("您的验证码是：" + Integer.parseInt(code) + "。请不要把验证码泄露给其他人。");
        url.append("&content=");
        url.append(content);
        RestTemplateBuilder restTemplateBuilder=new RestTemplateBuilder();
        RestTemplate client=restTemplateBuilder.build();
        System.out.println(url.toString());
        ResponseEntity<String> responseEntity=client.getForEntity(url.toString(),String.class);
        System.out.println(responseEntity);*/
        return code;
    }
}
