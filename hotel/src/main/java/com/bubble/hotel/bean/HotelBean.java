package com.bubble.hotel.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 酒店信息
 *
 * @author wugang
 * date: 2019-08-27 15:15
 **/
@ApiModel(value = "酒店信息对象", description = "hotel")
public class HotelBean implements Serializable {
    private static final long serialVersionUID = -6990200838718297268L;

    @ApiModelProperty(value = "酒店名称", required = true)
    private String name;
    @ApiModelProperty(value = "入住时间", required = true)
    private String checkInTime;
    @ApiModelProperty(value = "房型", required = true)
    private String houseType;
    @ApiModelProperty(value = "地址", required = true)
    private String address;
    @ApiModelProperty(value = "基础服务", required = true)
    private String generalAmenities;
    @ApiModelProperty(value = "导航", required = true)
    private String traffic;
    @ApiModelProperty(value = "呼叫", required = true)
    private String tel;
    @ApiModelProperty(value = "周边", required = true)
    private String nearbyAmenities;
    @ApiModelProperty(value = "酒店服务", required = true)
    private String hotelService;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGeneralAmenities() {
        return generalAmenities;
    }

    public void setGeneralAmenities(String generalAmenities) {
        this.generalAmenities = generalAmenities;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNearbyAmenities() {
        return nearbyAmenities;
    }

    public void setNearbyAmenities(String nearbyAmenities) {
        this.nearbyAmenities = nearbyAmenities;
    }

    public String getHotelService() {
        return hotelService;
    }

    public void setHotelService(String hotelService) {
        this.hotelService = hotelService;
    }

    @Override
    public String toString() {
        return "HotelBean{" +
                "name='" + name + '\'' +
                ", checkInTime='" + checkInTime + '\'' +
                ", houseType='" + houseType + '\'' +
                ", address='" + address + '\'' +
                ", generalAmenities='" + generalAmenities + '\'' +
                ", traffic='" + traffic + '\'' +
                ", tel='" + tel + '\'' +
                ", nearbyAmenities='" + nearbyAmenities + '\'' +
                ", hotelService='" + hotelService + '\'' +
                '}';
    }
}
