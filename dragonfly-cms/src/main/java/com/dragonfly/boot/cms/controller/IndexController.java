package com.dragonfly.boot.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by Administrator on 2017/9/25 0025.
 */
@Controller
public class IndexController
{
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test (Map<String,Object> map)
    {
        map.put("hello","from TemplateController.helloFtl");
        return "test";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login (Map<String,Object> map)
    {
        map.put("hello","from TemplateController.helloFtl");
        return "login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index (Map<String,Object> map)
    {
        map.put("hello","from TemplateController.helloFtl");
        return "index";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mian (Map<String,Object> map)
    {
        map.put("hello","from TemplateController.helloFtl");
        return "main";
    }

}
