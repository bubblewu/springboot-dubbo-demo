package com.bubble.service;

import com.bubble.bean.UserBean;

/**
 * 定义用户接口服务
 *
 * @author wugang
 * date: 2020-05-03 16:38
 **/
public interface UserService {

    UserBean query(String id);

}
