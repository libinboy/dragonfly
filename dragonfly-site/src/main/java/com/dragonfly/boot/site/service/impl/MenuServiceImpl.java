package com.dragonfly.boot.site.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dragonfly.boot.site.entity.Menu;
import com.dragonfly.boot.site.mapper.MenuMapper;
import com.dragonfly.boot.site.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/12/19 0019.
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService
{
}
