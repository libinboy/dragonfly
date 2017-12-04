package com.dragonfly.boot.site.controller;

import com.dragonfly.boot.site.service.UserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

}
