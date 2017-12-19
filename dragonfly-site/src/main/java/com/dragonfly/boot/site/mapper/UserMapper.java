package com.dragonfly.boot.site.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dragonfly.boot.site.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/11/2 0002.
 */
public interface UserMapper extends BaseMapper<User>
{

    /**
     * 自定义注入方法
     */
    int deleteAll();

}
