package com.codi.goldlife.boot.web.config;

import com.codi.base.spring.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;

import java.nio.charset.StandardCharsets;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-05-19 14:09
 */
@Slf4j
public class RedisTopicMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {

        RedisTemplate<String, String> redisTemplate = SpringContextHolder.getBean("redisTemplate");

        String channel = new String(message.getChannel(), StandardCharsets.UTF_8);
        String body = new String(message.getBody(), StandardCharsets.UTF_8);

        log.debug("channel={},body={} in msg", channel, body);
    }
}
