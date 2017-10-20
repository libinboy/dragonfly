package com.dragonfly.boot.cms.common;

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
}
