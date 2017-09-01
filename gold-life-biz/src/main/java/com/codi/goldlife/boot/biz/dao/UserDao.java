package com.codi.goldlife.boot.biz.dao;

import com.codi.goldlife.boot.api.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-02-23 10:05
 */

public interface UserDao {

    User addUser(User user);

    //注解和XML只能选择一个
    @Select("SELECT * FROM SYS_USER WHERE USER_ID=#{userId}")
    User getUser(Long userId);

    User getUser2(Long userId);

    List<User> selectUsers();

    int delUser(Long userId);
}
