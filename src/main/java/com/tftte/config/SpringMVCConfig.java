package com.tftte.config;

import com.tftte.common.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;


/**
 * @Author: tftte
 * @Date: 2020/6/14 21:16
 * @Description: SpringMVC相关配置
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.tftte", includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class))
public class SpringMVCConfig implements WebMvcConfigurer {

    @Autowired
    private DateConverter dateConverter;

    /**
     * 如果没有匹配到action就使用Servlet默认的访问
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // 给静态资源放行
        configurer.enable();
    }

    /**
     * 配置日期转换器
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(dateConverter);
    }

    /**
     * 添加视图控制器，如果没有指定，就访问这个页面
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("epidemic");
    }

    /**
     * 配置视图解析器(前后缀)
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/", ".jsp");
    }

}
