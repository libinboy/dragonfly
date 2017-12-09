package com.dragonfly.boot.site.config.kaptcha;

import com.google.code.kaptcha.servlet.KaptchaServlet;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.servlet.ServletException;

/**
 * Created by Administrator on 2017/10/13 0013.
 */
@Configuration
public class KaptchaConfiguration implements EnvironmentAware
{
    private RelaxedPropertyResolver propertyResolver;

    private String border;
    private String borderColor;
    private String textProducerFontColor;
    private String textProducerFontSize;
    private String textProducerFontNames;
    private String textProducerCharLength;
    private String imageWidth;
    private String imageHeight;

    @Override
    public void setEnvironment(Environment environment)
    {
        this.propertyResolver = new RelaxedPropertyResolver(environment, null);
        this.border = propertyResolver.getProperty("kaptcha.border");
        this.borderColor = propertyResolver.getProperty("kaptcha.borderColor");
        this.textProducerFontColor = propertyResolver.getProperty("kaptcha.textProducerFontColor");
        this.textProducerFontSize = propertyResolver.getProperty("kaptcha.textProducerFontSize");
        this.textProducerFontNames = propertyResolver.getProperty("kaptcha.textProducerFontNames");
        this.textProducerCharLength = propertyResolver.getProperty("kaptcha.textProducerCharLength");
        this.imageWidth = propertyResolver.getProperty("kaptcha.imageWidth");
        this.imageHeight = propertyResolver.getProperty("kaptcha.imageHeight");
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() throws ServletException{
        ServletRegistrationBean servlet = new ServletRegistrationBean(new KaptchaServlet(),"/images/kaptcha.jpg");
        servlet.addInitParameter("kaptcha.border", "no");//无边框
        servlet.addInitParameter("kaptcha.border.color", this.borderColor);
        servlet.addInitParameter("kaptcha.textproducer.font.color", this.textProducerFontColor);
        servlet.addInitParameter("kaptcha.textproducer.font.size", this.textProducerFontSize);
        servlet.addInitParameter("kaptcha.textproducer.char.length", this.textProducerCharLength);
        servlet.addInitParameter("kaptcha.textproducer.font.names", this.textProducerFontNames);
        servlet.addInitParameter("kaptcha.image.width", this.imageWidth);
        servlet.addInitParameter("kaptcha.image.height", this.imageHeight);
        return servlet;
    }


}
