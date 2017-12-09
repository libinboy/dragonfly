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
@RequestMapping("/")
public class WebIndexController
{
    /**
     * 默认跳转页面
     */
    @GetMapping
    public String index()
    {
        return "view/joke/index";
    }
}
