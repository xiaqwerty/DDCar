package com.example.ddcar;

import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CodeMessageTest
{
    @Test
    public void perform()
    {
        RestTemplateBuilder restTemplateBuilder=new RestTemplateBuilder();
        RestTemplate client=restTemplateBuilder.build();
        StringBuilder url;
        String content="您的验证码是:"+"1111"+"。请不要把验证码泄露给其他人。";
        ResponseEntity<String> responseEntity= null;
        try
        {
            responseEntity = client.getForEntity
                    ("http://hahaha/haha?method=Submit&account={APIID}&password={APIKEY}&mobile={phoneNumber}&content={content}",
                            String.class,"C72058701","d8c9d54356bc695d2b9b55b098dee673","13520136099", URLEncoder.encode(content,"UTF-8"));
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        System.out.println(responseEntity);
    }
}
