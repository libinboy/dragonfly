package com.dragonfly.boot.site.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/2 0002.
 */
@TableName("t_user")
public class User implements Serializable
{
    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 账号
     */
    @TableField("account")
    private String account;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 名称
     */
    @TableField("user_name")
    private String userName;

    public User() {
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    @Override public String toString()
    {
        return "User{" + "userId='" + userId + '\'' + ", account='" + account + '\'' + ", userName='" + userName + '\'' + '}';
    }
}
