package com.codi.goldlife.boot.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-05-19 14:38
 */
@Slf4j
@Configuration
public class RedisConfigTest {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    MessageListenerAdapter messageListener() {
        return new MessageListenerAdapter(new RedisTopicMessageListener());
    }

    @Bean
    RedisMessageListenerContainer redisContainer() {
        log.debug("redis container");
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();

        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(messageListener(), topic());

        return container;
    }


    @Bean
    ChannelTopic topic() {
        return new ChannelTopic("spy:channel");
    }
}
