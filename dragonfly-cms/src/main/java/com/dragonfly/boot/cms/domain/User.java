package com.dragonfly.boot.cms.domain;

/**
 * Created by Administrator on 2017/9/27 0027.
 */
public class User
{
    private Integer id;

    private String account;

    private String password;

    private String userName;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    @Override
    public String toString()
    {
        return "User [id=" + id + ", account=" + account + ", password=" + password + ", userName=" + userName + "]";
    }

}
