package com.dragonfly.boot.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by Administrator on 2017/12/9 0009.
 */
@ApiIgnore
@Controller
@RequestMapping("admin/login")
public class AdminLoginController
{
    @GetMapping
    public String login()
    {
        return "admin/login/login";
    }

}
