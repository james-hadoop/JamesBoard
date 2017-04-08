package org.cboard.pojo;

/**
 * Created by lijiang on 3/6/17.
 */
public class DashboardUserCity {


    private String userId;
    private String cityName;
    private Integer cityId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
