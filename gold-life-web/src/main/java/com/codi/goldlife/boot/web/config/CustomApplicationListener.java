package com.codi.goldlife.boot.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-02-21 11:24
 */
@Component
public class CustomApplicationListener implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger logger = LoggerFactory.getLogger(CustomApplicationListener.class);


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        logger.info("======= Application ready event =======");
        logger.info("======= do other things =======");
    }
}
