package com.codi.goldlife.boot.web.config;

import com.codi.goldlife.boot.web.BaseAppTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-02-21 11:05
 */
public class ConfigTest extends BaseAppTest {
    @Autowired
    private Environment env;

    @Value("${spy.app.name}")
    private String appName;

    @Test
    public void configTest() {
        logger.debug(appName);
        logger.debug(env.getProperty("spring.app.name"));
        logger.debug(env.getProperty("spy.user.home"));
        logger.debug(env.getProperty("spring.datasource.url"));
        logger.debug(env.getProperty("spring.velocity.enabled"));
    }
}
