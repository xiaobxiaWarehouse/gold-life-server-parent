package com.codi.goldlife.boot.web.dao;

import com.codi.goldlife.boot.api.domain.User;
import com.codi.goldlife.boot.biz.dao.UserDao;
import com.codi.goldlife.boot.web.BaseAppTest;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-02-23 10:36
 */
public class UserTest extends BaseAppTest {

    @Resource
    UserDao userDao;

    @Test
    public void getUser() {
        User user = userDao.getUser(1L);
        logger.debug(ToStringBuilder.reflectionToString(user));
    }

    @Test
    public void getUser2() {
        User user = userDao.getUser2(1L);
        logger.debug(ToStringBuilder.reflectionToString(user));
    }


    @Test
    public void getUsersTest() {
        PageHelper.startPage(1, 5, true);

        List<User> users = userDao.selectUsers();
        logger.debug(ToStringBuilder.reflectionToString(users));

        if (users != null) {
            Page page = (Page) users;
            logger.debug("total count={}", page.getTotal());

            for (User user : users) {
                logger.debug("id={}\tname={}", user.getId(), user.getUsername());
            }
        }
    }

}
