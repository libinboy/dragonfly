package com.dragonfly.boot.site.common;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/17 0017.
 */
public class ResponseJson implements Serializable
{

    /**
     * 状态码
     */
    private String status = StatusCode.SUCCESS;

    /**
     * 提示信息
     */
    private String message;

    private Object data;

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }
}
