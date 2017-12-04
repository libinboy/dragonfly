package com.dragonfly.boot.site;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Administrator on 2017/11/22 0022.
 */
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.dragonfly.boot.site.mapper*")
public class SiteApplication
{
    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(SiteApplication.class, args);
    }
}
