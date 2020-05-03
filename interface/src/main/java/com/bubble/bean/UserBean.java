package com.bubble.bean;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @author wugang
 * date: 2020-05-03 16:36
 **/
public class UserBean implements Serializable {
    private static final long serialVersionUID = 8747607316456969405L;

    private String id;
    private String name;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "UserBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
