package com.bubble.provider.service.impl;

import com.bubble.bean.CityBean;
import com.bubble.service.CityService;
import org.apache.dubbo.config.annotation.Service;

/**
 * 城市服务实现
 *
 * @author wugang
 * date: 2020-05-06 14:21
 **/
// 注册为 Dubbo 服务
@Service(version = "${dubbo.application.version}", application = "${dubbo.application.id}", group = "city",
        protocol = "${dubbo.protocol.id}", registry = "${dubbo.registry.id}")
public class CityServiceImpl implements CityService {

    @Override
    public CityBean findCityByName(String cityName) {
        return new CityBean(1L, 2L, cityName, "城市...");
    }

}
