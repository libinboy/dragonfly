package com.dragonfly.boot.cms.controller;

import com.dragonfly.boot.cms.domain.User;
import com.dragonfly.boot.cms.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/27 0027.
 */
@Api("用户服务")
@RestController
@RequestMapping("/user")
public class UserController
{

    @Resource
    private UserService userService;

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public List<User> queryUserList()
    {
        List<User> users = userService.queryAllUser();
        return users;
    }

    @ApiOperation(value = "根据登录名获取", notes = "")
    @RequestMapping(value = {"/query/username"}, method = RequestMethod.GET)
    public User queryUserByUserName(@RequestParam String userName)
    {
        User user = userService.queryUserByUserName(userName);
        return user;
    }

    @RequestMapping(value="/list/page", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findAllByPage(int page, int limit, String account){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        PageInfo<User> pager = userService.findUserByPage(page, limit, account);
        resultMap.put("code", 0);
        resultMap.put("msg", "OK");
        //总条数
        resultMap.put("total", pager.getTotal());
        //获取每页数据
        resultMap.put("rows", pager.getList());
        return resultMap;

    }

}
