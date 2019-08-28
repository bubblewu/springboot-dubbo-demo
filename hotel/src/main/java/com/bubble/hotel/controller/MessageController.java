package com.bubble.hotel.controller;

import com.bubble.hotel.bean.HotelBean;
import io.swagger.annotations.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;

/**
 * 酒店短信接口
 *
 * @author wugang
 * date: 2019-08-27 15:02
 **/
@RestController
@RequestMapping(value = "/hotel/msg/", produces = MediaType.APPLICATION_JSON_VALUE)
@EnableAutoConfiguration
@Api(tags = "酒店-短信信息解析接口")
public class MessageController {

    @GetMapping(path = "/test")
    @ApiOperation(value = "测试", notes = "测试接口")
    public String test() {
        Instant begin = Instant.now();
        System.out.println(Duration.between(begin, Instant.now()).toMillis());
        return "test swagger2";
    }

    @PostMapping(path = "/recognize/msg", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "酒店信息识别", notes = "根据短信信息识别酒店信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message", paramType = "body", dataType = "string", value = "预订酒店短信信息", required = true)
    })
    public HotelBean recognizeByMsg(@RequestBody String message) {
        HotelBean hotelBean = new HotelBean();
        hotelBean.setName("北京四季酒店");
        hotelBean.setCheckInTime("2019-08-29");
        hotelBean.setHouseType("豪华大床房");
        hotelBean.setAddress("北京朝阳区");
        hotelBean.setGeneralAmenities("24小时前台，行李寄存，叫醒服务");
        hotelBean.setTraffic("导航");
        hotelBean.setTel("呼叫");
        hotelBean.setNearbyAmenities("周边设施");
        hotelBean.setHotelService("酒店提供的相关服务");

        return hotelBean;
    }

    @GetMapping(path = "/recognize/name", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "酒店信息识别", notes = "根据酒店名获取完整酒店信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hotelName", paramType = "query", dataType = "string", value = "酒店名称", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public HotelBean recognizeByName(@RequestParam("hotelName") String hotelName) {
        HotelBean hotelBean = new HotelBean();
        hotelBean.setName("北京四季酒店");
        hotelBean.setCheckInTime("2019-08-29");
        hotelBean.setHouseType("豪华大床房");
        hotelBean.setAddress("北京朝阳区");
        hotelBean.setGeneralAmenities("24小时前台，行李寄存，叫醒服务");
        hotelBean.setTraffic("导航");
        hotelBean.setTel("呼叫");
        hotelBean.setNearbyAmenities("周边设施");
        hotelBean.setHotelService("酒店提供的相关服务");

        return hotelBean;
    }

    @PostMapping(path = "/recognize", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "酒店信息识别", notes = "根据短信和酒店名获取完整酒店信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message", paramType = "body", dataType = "string", value = "酒店预订短信", required = true),
            @ApiImplicitParam(name = "hotelName", paramType = "body", dataType = "string", value = "酒店名称", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public HotelBean recognize(@RequestBody(required = true) String message, String hotelName) {
        HotelBean hotelBean = new HotelBean();
        hotelBean.setName("北京四季酒店");
        hotelBean.setCheckInTime("2019-08-29");
        hotelBean.setHouseType("豪华大床房");
        hotelBean.setAddress("朝阳区");
        hotelBean.setGeneralAmenities("24小时前台，行李寄存，叫醒服务");
        hotelBean.setTraffic("http://xxxxxx");
        hotelBean.setTel("http://xxxxxx");
        hotelBean.setNearbyAmenities("http://xxxxxx");
        hotelBean.setHotelService("http://xxxxxx");

        return hotelBean;
    }

}
