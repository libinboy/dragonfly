package com.dragonfly.boot.cms.config.druid.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

import java.io.IOException;

/** 
 * Created by ljmh on 2016/12/28. 
 * Druid拦截器，用于查看Druid监控 
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*", 
    initParams = {
        @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源  
})
public class DruidStatFilter extends WebStatFilter
{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        response.setContentType("text/html");
        super.doFilter(request, response, chain);
    }

}
