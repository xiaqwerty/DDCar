package com.example.ddcar.common.result;

public class Response
{
    private String rspCode="200";
    private String rspMsg="操作成功";

    public Response(ExceptionMsg msg)
    {
        this.rspCode=msg.getCode();
        this.rspMsg=msg.getMsg();
    }
    public Response() {}

    public String getRspCode()
    {
        return rspCode;
    }

    public String getRspMsg()
    {
        return rspMsg;
    }
}
