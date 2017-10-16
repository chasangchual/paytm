
package com.sangchual.paytm.softwarechallenges.openweathermap.entity.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class WeatherForecast {

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Double message;
    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<com.sangchual.paytm.softwarechallenges.openweathermap.entity.forecast.List> list = null;
    @SerializedName("city")
    @Expose
    private City city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public WeatherForecast withCod(String cod) {
        this.cod = cod;
        return this;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public WeatherForecast withMessage(Double message) {
        this.message = message;
        return this;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public WeatherForecast withCnt(Integer cnt) {
        this.cnt = cnt;
        return this;
    }

    public java.util.List<com.sangchual.paytm.softwarechallenges.openweathermap.entity.forecast.List> getList() {
        return list;
    }

    public void setList(java.util.List<com.sangchual.paytm.softwarechallenges.openweathermap.entity.forecast.List> list) {
        this.list = list;
    }

    public WeatherForecast withList(java.util.List<com.sangchual.paytm.softwarechallenges.openweathermap.entity.forecast.List> list) {
        this.list = list;
        return this;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public WeatherForecast withCity(City city) {
        this.city = city;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("cod", cod).append("message", message).append("cnt", cnt).append("list", list).append("city", city).toString();
    }

}
