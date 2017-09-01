package com.codi.goldlife.boot.console.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-03-20 15:30
 */
@Configuration
public class WebConfig {
    @Bean
    public ServletRegistrationBean customServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();

        CustomServlet customServlet = new CustomServlet();
        registrationBean.setServlet(customServlet);
        List<String> urlMappings = new ArrayList<String>();
        urlMappings.add("/demoServlet");
        registrationBean.setUrlMappings(urlMappings);
        registrationBean.setLoadOnStartup(1);

        return registrationBean;
    }
}
