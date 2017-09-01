package com.codi.goldlife.boot.api.domain;

import java.io.Serializable;

/**
 * User
 *
 * @author shi.pengyan
 * @date 2017-02-21 10:13
 */

public class User implements Serializable {
    private Long id;
    private String username;
    private String pwd;
    private int age;
    private String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
