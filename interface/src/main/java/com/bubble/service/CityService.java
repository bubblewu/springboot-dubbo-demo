package com.bubble.service;

import com.bubble.bean.CityBean;

/**
 * 城市服务
 *
 * @author wugang
 * date: 2020-05-06 14:15
 **/
public interface CityService {

    /**
     *
     * @param cityName 城市名
     */
    CityBean findCityByName(String cityName);

}
