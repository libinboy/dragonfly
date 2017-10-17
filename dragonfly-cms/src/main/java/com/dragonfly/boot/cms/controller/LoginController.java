package com.dragonfly.boot.cms.controller;

import com.dragonfly.boot.cms.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/10/12 0012.
 */
@Api("登陆服务")
@RestController
@RequestMapping("/login")
public class LoginController
{
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private UserService userService;

    @ApiOperation(value = "登陆", notes = "")
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    @ResponseBody
    public String login(String userName, String password)
    {
        logger.debug("userName" + userName);
        logger.debug("password" + password);
        return "true";
    }
}
