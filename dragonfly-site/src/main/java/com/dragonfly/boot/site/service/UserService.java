package com.dragonfly.boot.site.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.dragonfly.boot.site.entity.User;

/**
 * Created by Administrator on 2017/11/2 0002.
 */
public interface UserService extends IService<User>
{

    boolean deleteAll();

}
