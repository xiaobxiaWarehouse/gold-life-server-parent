package com.codi.goldlife.boot.web.config;

import com.alibaba.fastjson.JSONObject;
import com.codi.goldlife.boot.web.BaseAppTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-05-19 14:07
 */
@Slf4j
public class RedisTest extends BaseAppTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testName() throws IOException {
        String channel = "spy:channel";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "老鹰");

        redisTemplate.convertAndSend(channel, jsonObject.toJSONString());
        log.debug("redis send over!");
        System.in.read();
    }
}
