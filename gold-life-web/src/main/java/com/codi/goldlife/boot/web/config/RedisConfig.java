package com.codi.goldlife.boot.web.config;

import com.codi.base.util.RSAUtil;
import com.codi.base.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

import static org.apache.tomcat.jni.SSL.setPassword;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-03-17 12:43
 */
@Configuration
@Slf4j
public class RedisConfig {

    private final String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJrnsGEkWjTdfPGUTlSa7rt24RaWNXZLB8c8eDVyHJRNSU82G+3BwiRpcsZsViX/Ow/McgD0AZfG0kp3nIRtM4+w3MlKsVZhH9mm9OogwoDIAHlYe7zG7uiY5qEjlUwJgs4QdU7Oy2xYDlejlXfEMHXu3IDw7etDWHtR2Bp2R8Z/AgMBAAECgYAPkIIXcKijsTGRsH4iYCLmsS4yr8sVZLqWWUwWyq12dUGNdPlfbV2NfQ7sQwxw6vFLSBaYY+wZDQAqPVR7teE9QLnSZe5Su+RIki8/Wj9jSV/eDEnbU6ZbON9QTn2wl4wuOrmO8hwftapR1XpjCxdwHjHIkZ7MQ/rL8Wfn93Fy6QJBAPxZJqi7tqIAGv/aXB5Fa2kBaAp2oXw6m+2Kn6GuaJUP+tXyRjCBl13BBvtAWf05BvBy1oz74/nomJufbUpLt5UCQQCdJYzLN83sVh1WSX8P30OaqlcA+JCF2O0GYv8kwSziArb4Hpcc0+1mdF3ERqJTmh9ZxpbH9a/wy/yEix5TszDDAkBtP9eJ04LVDgCiZhHdlSZUVqSJaySsmN8q7wn/QHfMmRd6iqIym9hBYbE5E3oiNA86CC206dSgPD/dmB8DvFYlAkEAl/vxJ7pZFvJSfVmn4hn0sGl+rBm67TjYRQ0J5upOFmi5vU8Yp3Dwcd6psWL/LAwrthAzVEFyYFlpaGeEdT8hMQJACGhHiiv4CuVHVkRg3NpDlvlV3px3ysKqHOHyd21Duyqdx107bkdQPKLJJj14fD//D9siN9eocIaBg4nw5b3YBg==";

    @Bean(name = "redisConnectionFactory")
    public JedisConnectionFactory getRedisConnectionFactory(
        @Value("${spring.redis.host}") String host,
        @Value("${spring.redis.port}") int port,
        @Value("${spring.redis.maxIdle}") int maxIdle,
        @Value("${spring.redis.maxTotal}") int maxTotal,
        @Value("${spring.redis.maxWaitMillis}") int maxWaitMillis,
        @Value("${spring.redis.testOnBorrow}") Boolean testOnBorrow,
        @Value("${spring.redis.encrypt}") Boolean encrypt,
        @Value("${spring.redis.dataBase}") int dataBase,
        @Value("${spring.redis.publicKey}") String publicKey,
        @Value("${spring.redis.password}") String password
    ) {
        JedisConnectionFactory factory = new JedisConnectionFactory();

        factory.setHostName(host);
        factory.setPort(port);
        factory.setUsePool(true);
        factory.setDatabase(dataBase);

        if (encrypt) {
            try {
                byte[] buffer = RSAUtil.decrypt(RSAUtil.loadPrivateKeyByStr(privateKey), Base64.decodeBase64(password));
                String pwd = new String(buffer);
                factory.setPassword(pwd);
            } catch (Exception e) {
                log.error("error", e);
            }

        } else {
            if (StringUtil.isNotEmpty(password)) {
                setPassword(password);
            }
        }

        // 设置jedis连接池配置
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxWaitMillis(maxWaitMillis);
        // testOnBorrow：在borrow一个jedis实例时，是否提前进行alidate操作；如果为true，则得到的jedis实例均是可用的；
        poolConfig.setTestOnBorrow(testOnBorrow);

        factory.setPoolConfig(poolConfig);
        return factory;
    }
}
