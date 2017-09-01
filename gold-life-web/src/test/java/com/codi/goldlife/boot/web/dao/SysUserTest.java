package com.codi.goldlife.boot.web.dao;

import com.codi.superman.base.dao.SysUserDao;
import com.codi.goldlife.boot.web.BaseAppTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-02-24 21:15
 */
public class SysUserTest extends BaseAppTest {

    @Autowired
    SysUserDao sysUserDao;

    @Test
    public void test() {
        System.out.println(sysUserDao.getUsersCount());
    }
}
