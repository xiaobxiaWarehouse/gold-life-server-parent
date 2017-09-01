package com.codi.goldlife.boot.biz.dao.impl;

import com.codi.goldlife.boot.api.domain.User;
import com.codi.goldlife.boot.biz.dao.UserDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-02-23 10:05
 */
@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

//    @Autowired
//    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User getUser(Long userId) {
        return null;
    }

    @Override
    public User getUser2(Long userId) {
//        getSqlSession().select(User.class.getName() + "." + "selectByPrimaryKey", userId);
        return getSqlSession().selectOne(User.class.getName() + "." + "selectByPrimaryKey", userId);
    }

    @Override
    public List<User> selectUsers() {
        return getSqlSession().selectList(User.class.getName() + "." + "selectUsers");
//        return getSqlSession().selectList(User.class.getName() + "." + "getUsers", null, new RowBounds(pageNum, pageSize));
    }

    @Override
    public int delUser(Long userId) {
        return 0;
    }

}
