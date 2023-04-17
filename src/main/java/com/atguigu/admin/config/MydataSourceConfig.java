package com.atguigu.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author xuhaiqing
 * @version 1.0
 * @Description
 * @date 2023/4/6 0006 17:27
 */
@Configuration
public class MydataSourceConfig {

    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource getDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }
}
