package com.etoak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 使用jsp正常部署到服务器需要打war包，实现这个方法
 */
@SpringBootApplication
@MapperScan(basePackages = "com.etoak.mapper")
public class Boot13App extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Boot13App.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Boot13App.class, args);
    }
}
