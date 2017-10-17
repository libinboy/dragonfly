package com.dragonfly.boot.cms.config.druid;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

/**  
 * Druid的DataResource配置类  
 * 凡是被Spring管理的类，实现接口 EnvironmentAware 重写方法 setEnvironment 可以在工程启动时，  
 * 获取到系统环境变量和application配置文件中的变量。 还有一种方式是采用注解的方式获取 @value("${变量的key值}")  
 * 获取application配置文件中的变量。 这里采用第一种要方便些  
 * Created by sun on 2017-1-20.  
 */
@Configuration
public class DruidConfiguration implements EnvironmentAware
{

    private RelaxedPropertyResolver propertyResolver;

    private String driveClassName;

    private String url;

    private String userName;

    private String password;

    private String filters;

    private String maxActive;

    private String initialSize;

    private String maxWait;

    private String minIdle;

    private String timeBetweenEvictionRunsMillis;

    private String minEvictableIdleTimeMillis;

    private String validationQuery;

    private String testWhileIdle;

    private String testOnBorrow;

    private String testOnReturn;

    private String poolPreparedStatements;

    private String maxOpenPreparedStatements;

    @Bean
    @Primary
    public DataSource druidDataSource()
    {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(StringUtils.isNotBlank(driveClassName) ? driveClassName : "com.mysql.jdbc.Driver");
        druidDataSource.setMaxActive(StringUtils.isNotBlank(maxActive) ? Integer.parseInt(maxActive) : 10);
        druidDataSource.setInitialSize(StringUtils.isNotBlank(initialSize) ? Integer.parseInt(initialSize) : 1);
        druidDataSource.setMaxWait(StringUtils.isNotBlank(maxWait) ? Integer.parseInt(maxWait) : 60000);
        druidDataSource.setMinIdle(StringUtils.isNotBlank(minIdle) ? Integer.parseInt(minIdle) : 3);
        druidDataSource.setTimeBetweenEvictionRunsMillis(StringUtils.isNotBlank(timeBetweenEvictionRunsMillis) ? Integer.parseInt(timeBetweenEvictionRunsMillis) : 60000);
        druidDataSource.setMinEvictableIdleTimeMillis(StringUtils.isNotBlank(minEvictableIdleTimeMillis) ? Integer.parseInt(minEvictableIdleTimeMillis) : 300000);
        druidDataSource.setValidationQuery(StringUtils.isNotBlank(validationQuery) ? validationQuery : "select 'x'");
        druidDataSource.setTestWhileIdle(StringUtils.isNotBlank(testWhileIdle) ? Boolean.parseBoolean(testWhileIdle) : true);
        druidDataSource.setTestOnBorrow(StringUtils.isNotBlank(testOnBorrow) ? Boolean.parseBoolean(testOnBorrow) : false);
        druidDataSource.setTestOnReturn(StringUtils.isNotBlank(testOnReturn) ? Boolean.parseBoolean(testOnReturn) : false);
        druidDataSource.setPoolPreparedStatements(StringUtils.isNotBlank(poolPreparedStatements) ? Boolean.parseBoolean(poolPreparedStatements) : true);
        druidDataSource.setMaxOpenPreparedStatements(StringUtils.isNotBlank(maxOpenPreparedStatements) ? Integer.parseInt(maxOpenPreparedStatements) : 20);

        try
        {
            druidDataSource.setFilters(StringUtils.isNotBlank(filters) ? filters : "stat, wall");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return druidDataSource;
    }

    @Override
    public void setEnvironment(Environment environment)
    {
        this.propertyResolver = new RelaxedPropertyResolver(environment, null);
        this.url = propertyResolver.getProperty("spring.datasource.url");
        this.userName = propertyResolver.getProperty("spring.datasource.username");
        this.password = propertyResolver.getProperty("spring.datasource.password");
        this.driveClassName = propertyResolver.getProperty("spring.datasource.driver-class-name");
        this.filters = propertyResolver.getProperty("spring.datasource.filters");
        this.maxActive = propertyResolver.getProperty("spring.datasource.maxActive");
        this.initialSize = propertyResolver.getProperty("spring.datasource.initialSize");
        this.maxWait = propertyResolver.getProperty("spring.datasource.maxWait");
        this.minIdle = propertyResolver.getProperty("spring.datasource.minIdle");
        this.timeBetweenEvictionRunsMillis = propertyResolver.getProperty("spring.datasource.timeBetweenEvictionRunsMillis");
        this.minEvictableIdleTimeMillis = propertyResolver.getProperty("spring.datasource.minEvictableIdleTimeMillis");
        this.validationQuery = propertyResolver.getProperty("spring.datasource.validationQuery");
        this.testWhileIdle = propertyResolver.getProperty("spring.datasource.testWhileIdle");
        this.testOnBorrow = propertyResolver.getProperty("spring.datasource.testOnBorrow");
        this.testOnReturn = propertyResolver.getProperty("spring.datasource.testOnReturn");
        this.poolPreparedStatements = propertyResolver.getProperty("spring.datasource.poolPreparedStatements");
        this.maxOpenPreparedStatements = propertyResolver.getProperty("spring.datasource.maxOpenPreparedStatements");
    }


}
