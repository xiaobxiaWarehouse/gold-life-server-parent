package com.codi.goldlife.boot.web.config;

import com.codi.superman.base.intercept.TokenInteceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * Web Config
 *
 * @author shi.pengyan
 * @date 2017-03-17 11:14
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LocaleChangeInterceptor());

        registry.addInterceptor(new TokenInteceptor())
            .addPathPatterns("/sys/**")
            .excludePathPatterns("/", "/sys/login", "/sys/isLogin", "/sys/logout", "/error");
    }

}
