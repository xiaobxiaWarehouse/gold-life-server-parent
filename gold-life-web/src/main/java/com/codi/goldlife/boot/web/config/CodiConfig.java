package com.codi.goldlife.boot.web.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.IntrospectorCleanupListener;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-03-17 9:57
 */
@Configuration
public class CodiConfig {

    /**
     * 注入FastJSON
     *
     * @return
     */
    @Bean
    public FastJsonHttpMessageConverter4 fastJsonHttpMessageConverters() {
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonHttpMessageConverter4 fastConverter = new FastJsonHttpMessageConverter4();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
            SerializerFeature.PrettyFormat,
            SerializerFeature.QuoteFieldNames,
            SerializerFeature.IgnoreErrorGetter
        );
        //
        fastConverter.setFastJsonConfig(fastJsonConfig);
//        return new HttpMessageConverters(fastConverter);
        return fastConverter;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    //    @Bean
//    public FilterRegistrationBean customFilter() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        CustomFilter customFilter = new CustomFilter();
//
//        registrationBean.setFilter(customFilter);
//        List<String> urlPatterns = new ArrayList<String>();
//        urlPatterns.add("/*");//拦截路径，可以添加多个
//        registrationBean.setUrlPatterns(urlPatterns);
//        registrationBean.setOrder(1);
//
//        return registrationBean;
//    }
//
//
    @Bean
    public ServletListenerRegistrationBean customListener() {
        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean();

        IntrospectorCleanupListener customListener = new IntrospectorCleanupListener();
        registrationBean.setListener(customListener);
        registrationBean.setOrder(1);

        return registrationBean;
    }
//
//    @Bean
//    public ServletRegistrationBean customServlet() {
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
//
//        CustomServlet customServlet = new CustomServlet();
//        registrationBean.setServlet(customServlet);
//        List<String> urlMappings = new ArrayList<String>();
//        urlMappings.add("/demoServlet");
//        registrationBean.setUrlMappings(urlMappings);
//        registrationBean.setLoadOnStartup(1);
//
//        return registrationBean;
//    }
}
