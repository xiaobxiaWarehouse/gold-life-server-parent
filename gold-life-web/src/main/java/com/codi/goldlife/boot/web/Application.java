package com.codi.goldlife.boot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * BootStrap
 *
 * @author shi.pengyan
 * @date 2017-02-21 10:50
 */
@SpringBootApplication(scanBasePackages = "com.codi")
@EnableTransactionManagement // 启注解事务管理
@EnableConfigurationProperties
@PropertySources({
    @PropertySource(value = "file:${user.home}/codi_application.properties", ignoreResourceNotFound = true, encoding = "UTF-8")
})
@ImportResource(locations = {"classpath:spring/spring-application.xml"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
