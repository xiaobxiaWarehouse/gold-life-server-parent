package com.codi.goldlife.boot.web.controller;

import com.codi.goldlife.boot.api.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模块名
 *
 * @author shi.pengyan
 * @date 2017-03-05 19:31
 */
@RestController
public class UserController {
    @ApiOperation(value = "获取用户基本信息", notes = "")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId", value = "", required = false, dataType = "User")
    })
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable("userId") Long userId) {
        User user = new User();
        user.setId(userId);
        user.setUsername("smith");

        return user;
    }
}
