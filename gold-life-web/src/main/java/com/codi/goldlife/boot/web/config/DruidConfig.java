package com.codi.goldlife.boot.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-02-23 14:41
 */
@Configuration
public class DruidConfig {
    private static final Logger logger = LoggerFactory.getLogger(DruidConfig.class);


    @Bean("druidDataSource")
    @Primary
    public DataSource druidDataSource(
        @Value("${spring.datasource.driverClassName}") String driver,
        @Value("${spring.datasource.url}") String url,
        @Value("${spring.datasource.username}") String username,
        @Value("${spring.datasource.password}") String password,
        @Value("${spring.datasource.initialSize}") int initialSize,
        @Value("${spring.datasource.minIdle}") int minIdle,
        @Value("${spring.datasource.maxActive}") int maxActive,
        @Value("${spring.datasource.maxWait}") long maxWait,
        @Value("${spring.datasource.timeBetweenEvictionRunsMillis}") long timeBetweenEvictionRunsMillis,
        @Value("${spring.datasource.minEvictableIdleTimeMillis}") long minEvictableIdleTimeMillis,
        @Value("${spring.datasource.validationQuery}") String validationQuery,
        @Value("${spring.datasource.testWhileIdle}") boolean testWhileIdle,
        @Value("${spring.datasource.testOnBorrow}") boolean testOnBorrow,
        @Value("${spring.datasource.testOnReturn}") boolean testOnReturn,
        @Value("${spring.datasource.poolPreparedStatements}") boolean poolPreparedStatements,
        @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}") int maxPoolPreparedStatementPerConnectionSize,
        @Value("${spring.datasource.filters}") String filters,
        @Value("${spring.datasource.connectionProperties}") String connectionProperties) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource
            .setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource
            .setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource
            .setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        druidDataSource.setConnectionProperties(connectionProperties);

        //logger.debug("password={}", password);
        //logger.debug("connectionProperties={}", connectionProperties);
        try {
            druidDataSource.setFilters(filters);
        } catch (SQLException e) {
            logger.error("druid set filters error", e);
        }
        return druidDataSource;
    }
}
