package com.bubble.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.bubble.bean.CityBean;
import com.bubble.bean.UserBean;
import com.bubble.service.CityService;
import com.bubble.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    // Dubbo中远程接口引用注解
    @Reference(version = "${dubbo.application.version}", group = "user",
            application = "${dubbo.application.id}", registry = "${dubbo.registry.id}")
    private UserService userService;
    @Reference(version = "${dubbo.application.version}", group = "city",
            application = "${dubbo.application.id}", registry = "${dubbo.registry.id}")
    private CityService cityService;

    @GetMapping("/query")
    @ResponseBody
    public String query(@RequestParam("id") String id) {
        UserBean result = userService.query(id);
        logger.info("result: {}", result);
        return JSON.toJSONString(result);
    }

    @GetMapping("/query/city")
    @ResponseBody
    public String queryCity(@RequestParam("name") String name) {
        CityBean city = cityService.findCityByName(name);
        logger.info("city: {}", city);
        return JSON.toJSONString(city);
    }

}
