package com.dragonfly.boot.cms.service;

import java.util.List;

import com.dragonfly.boot.cms.domain.User;
import com.github.pagehelper.PageInfo;

public interface UserService
{

    List<User> queryAllUser();

    User queryUserByUserName(String userName);

    PageInfo<User> findUserByPage(int page, int pageSize);

}
