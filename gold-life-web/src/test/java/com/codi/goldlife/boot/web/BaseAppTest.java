package com.codi.goldlife.boot.web;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试基类，所有测试类都要继承这个类
 *
 * @author shi.pengyan
 * @date 2017-02-21 11:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class BaseAppTest {

    protected Logger logger = LoggerFactory.getLogger(getClass());

}
