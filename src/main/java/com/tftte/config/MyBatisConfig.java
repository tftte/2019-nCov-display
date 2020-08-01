package com.tftte.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: tftte
 * @Date: 2020/8/1 20:47
 * @Description: 对MyBatis的配置，等同于mybatis.xml + spring-bean.xml
 */
@Configuration
@MapperScan(basePackages = "com.tftte.mapper")
public class MyBatisConfig {

    /**
     * 配置数据源
     * @return
     */
    @Bean(name = "dataSource", destroyMethod = "close")
    public BasicDataSource basicDataSource() {
        Properties properties = new Properties();
        try {
            InputStream in = new DefaultResourceLoader().getResource("db.properties").getInputStream();
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(properties.getProperty("jdbc.driver"));
        dataSource.setUrl(properties.getProperty("jdbc.url"));
        dataSource.setUsername(properties.getProperty("jdbc.username"));
        dataSource.setPassword(properties.getProperty("jdbc.password"));
        dataSource.setDefaultAutoCommit(false);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);

        factoryBean.setTypeAliasesPackage("com.tftte.bean");

        // 为了让MyBatis自动将下划线分割的列名转换为小驼峰表示的属性名
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);

        factoryBean.setConfiguration(configuration);

        SqlSessionFactory factory = null;
        // 设置映射xml文件的路径
        try {
            Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:com/tftte/mapper/*Mapper.xml");
            factoryBean.setMapperLocations(resources);
            factory = factoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return factory;
    }
}
