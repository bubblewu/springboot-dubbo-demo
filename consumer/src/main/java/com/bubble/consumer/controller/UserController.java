package com.bubble.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.bubble.bean.UserBean;
import com.bubble.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * 用户服务
 *
 * @author wugang
 * date: 2020-05-03 16:48
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    // Dubbo中远程接口引用注解
    @Reference
    private UserService userService;

    @GetMapping("/query")
    @ResponseBody
    public String query(@RequestParam("id") String id) {
        UserBean result = userService.query(id);
        System.out.println("result: " + result);
        return JSON.toJSONString(result);
    }

}
