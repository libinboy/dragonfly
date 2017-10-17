package com.dragonfly.boot.cms.mapper;

import java.util.List;

import com.dragonfly.boot.cms.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper
{

    List<User> queryAllUser();

    User queryUserByUserName(@Param("userName") String userName);

}
