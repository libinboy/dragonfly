package com.dragonfly.boot.site.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dragonfly.boot.site.entity.Joke;
import com.dragonfly.boot.site.mapper.JokeMapper;
import com.dragonfly.boot.site.service.JokeService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/12/4 0004.
 */
@Service
public class JokeServiceImpl extends ServiceImpl<JokeMapper, Joke> implements JokeService
{
}
