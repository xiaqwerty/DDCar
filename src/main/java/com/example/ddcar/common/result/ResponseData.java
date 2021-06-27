package com.example.ddcar.common.result;

public class ResponseData extends Response
{
    private Object data;
    public ResponseData(Object data)
    {
        super();
        this.data=data;
    }
    public ResponseData(ExceptionMsg msg,Object data)
    {
        super(msg);
        this.data=data;
    }
    public Object getData()
    {
        return data;
    }
}