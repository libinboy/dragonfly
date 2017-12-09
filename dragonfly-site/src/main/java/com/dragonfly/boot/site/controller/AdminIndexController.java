package com.dragonfly.boot.site.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by Administrator on 2017/12/9 0009.
 */
@ApiIgnore
@Controller
@RequestMapping(value = "/admin/index")
public class AdminIndexController
{

    @GetMapping
    public String index()
    {
        return "admin/index";
    }

}
