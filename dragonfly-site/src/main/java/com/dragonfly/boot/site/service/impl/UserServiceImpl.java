package com.dragonfly.boot.site.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dragonfly.boot.site.entity.User;
import com.dragonfly.boot.site.mapper.UserMapper;
import com.dragonfly.boot.site.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/2 0002.
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService
{
    @Override
    public boolean deleteAll() {
        return retBool(baseMapper.deleteAll());
    }
}
