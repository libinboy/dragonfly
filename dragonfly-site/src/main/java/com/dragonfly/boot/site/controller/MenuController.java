package com.dragonfly.boot.site.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.dragonfly.boot.site.entity.Menu;
import com.dragonfly.boot.site.service.MenuService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/19 0019.
 */
@Api("菜单管理")
@Controller
@RequestMapping("/menu")
public class MenuController
{

    private Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    @RequestMapping(value="/list/page", method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findAllByPage(int pageNo, int pageSize, String name){

        logger.debug("pageNo:" + pageNo);
        logger.debug("pageSize:" + pageSize);
        logger.debug("name:" + name);

        Page<Menu> page = new Page<>(pageNo, pageSize);
        Menu m = new Menu();
        m.setName(name);
        EntityWrapper<Menu> entityWrapper = new EntityWrapper<>(m);
        menuService.selectPage(page, entityWrapper);


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
