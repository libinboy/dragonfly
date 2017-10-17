package com.dragonfly.boot.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by Administrator on 2017/9/25 0025.
 */
@SpringBootApplication
@RestController
@ServletComponentScan
@MapperScan("com.dragonfly.boot.cms.mapper")
public class CmsApplication
{
    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(CmsApplication.class, args);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiIgnore
    public String sayHello ()
    {
        return "Hello boy.";
    }
}
