package com.dragonfly.boot.cms.controller;

import com.dragonfly.boot.cms.common.ResponseJson;
import com.dragonfly.boot.cms.common.StatusCode;
import com.dragonfly.boot.cms.domain.User;
import com.dragonfly.boot.cms.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
    public ResponseJson login(String userName, String password, String captcha, HttpSession session)
    {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setStatus(StatusCode.FAIL);

        String key = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

        logger.debug("userName" + userName);
        logger.debug("password" + password);

        if (StringUtils.isEmpty(captcha) || !captcha.equals(key))
        {
            responseJson.setMessage("验证码错误");
            return responseJson;
        }

        User user = userService.queryUserByUserName(userName);

        if (user == null)
        {
            responseJson.setMessage("用户名或密码错误");
            return responseJson;
        }

        if (!StringUtils.equals(user.getPassword(), password))
        {
            responseJson.setMessage("用户名或密码错误");
            return responseJson;
        }

        responseJson.setStatus(StatusCode.SUCCESS);
        return responseJson;
    }
}
