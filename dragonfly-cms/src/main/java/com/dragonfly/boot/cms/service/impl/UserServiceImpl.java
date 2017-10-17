package com.dragonfly.boot.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.dragonfly.boot.cms.domain.User;
import com.dragonfly.boot.cms.mapper.UserMapper;
import com.dragonfly.boot.cms.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> queryAllUser()
    {
        return userMapper.queryAllUser();
    }

    @Override
    public User queryUserByUserName(String userName)
    {
        return userMapper.queryUserByUserName(userName);
    }

    @Override
    public PageInfo<User> findUserByPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<User> list = userMapper.queryAllUser();
        return new PageInfo<User>(list);
    }
}
