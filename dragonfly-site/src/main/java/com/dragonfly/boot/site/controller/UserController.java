package com.dragonfly.boot.site.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.dragonfly.boot.site.entity.User;
import com.dragonfly.boot.site.service.UserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/25 0025.
 */
@Api("用户管理服务")
@Controller
@RequestMapping(value = "/user")
public class UserController
{
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="/list/page", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findAllByPage(int pageNo, int pageSize, String account){

        logger.debug("pageNo:" + pageNo);
        logger.debug("pageSize:" + pageSize);
        logger.debug("account:" + account);

        Page<User> page = new Page<>(pageNo, pageSize);
        User u = new User();
        u.setAccount(account);
        EntityWrapper<User> entityWrapper = new EntityWrapper<>(u);
        userService.selectPage(page, entityWrapper);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 0);
        resultMap.put("msg", "OK");
        //总条数
        resultMap.put("total", page.getTotal());
        //获取每页数据
        resultMap.put("rows", page.getRecords());
        return resultMap;
    }

}
