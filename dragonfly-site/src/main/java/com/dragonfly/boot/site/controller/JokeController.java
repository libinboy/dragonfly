package com.dragonfly.boot.site.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.dragonfly.boot.site.common.ResponseJson;
import com.dragonfly.boot.site.entity.Joke;
import com.dragonfly.boot.site.entity.User;
import com.dragonfly.boot.site.service.JokeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/4 0004.
 */
@Api("笑话服务")
@Controller
@RequestMapping(value = "/joke")
public class JokeController
{
    private Logger logger = LoggerFactory.getLogger(JokeController.class);

    @Resource
    private JokeService jokeService;

    @ApiOperation(value = "查询笑话列表", notes = "")
    @GetMapping("/list/all")
    @ResponseBody
    public ResponseJson getAllJoke()
    {
        ResponseJson responseJson = new ResponseJson();
        EntityWrapper<Joke> ew = new EntityWrapper<>();
        List<Joke> jokes = jokeService.selectList(ew);
        responseJson.setData(jokes);
        return responseJson;
    }

    @RequestMapping(value="/list/page", method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getByPage(int pageNo, int pageSize, String jokeContent){

        logger.debug("pageNumber:" + pageNo);
        logger.debug("pageSize:" + pageSize);
        logger.debug("account:" + jokeContent);

        Page<Joke> page = new Page<>(pageNo, pageSize);
        Joke j = new Joke();
        j.setJokeContent(jokeContent);
        EntityWrapper<Joke> entityWrapper = new EntityWrapper<>(j);
        jokeService.selectPage(page, entityWrapper);


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
