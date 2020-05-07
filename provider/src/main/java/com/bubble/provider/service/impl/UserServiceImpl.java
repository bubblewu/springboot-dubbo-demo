package com.bubble.provider.service.impl;

import com.bubble.bean.UserBean;
import com.bubble.service.UserService;
import org.apache.dubbo.config.annotation.Service;

/**
 * 用户接口服务的具体实现类
 *
 * @author wugang
 * date: 2020-05-03 16:39
 **/
// 注意：这里的service注解用的不是spring的注解，
// 而是org.apache.dubbo.config.annotation.Service;
@Service(version = "${dubbo.application.version}", application = "${dubbo.application.id}", group = "user",
        protocol = "${dubbo.protocol.id}", registry = "${dubbo.registry.id}")
public class UserServiceImpl implements UserService {

    @Override
    public UserBean query(String id) {
        UserBean user = new UserBean();
        user.setId(id);
        user.setName("Dubbo");
        user.setAddress("北京");
        return user;
    }
}
