
package com.sangchual.paytm.softwarechallenges.openweathermap.entity.daily;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class DailyForecast {

    @SerializedName("city")
    @Expose
    private City city;
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
    private java.util.List<com.sangchual.paytm.softwarechallenges.openweathermap.entity.daily.List> list = null;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public DailyForecast withCity(City city) {
        this.city = city;
        return this;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public DailyForecast withCod(String cod) {
        this.cod = cod;
        return this;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public DailyForecast withMessage(Double message) {
        this.message = message;
        return this;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public DailyForecast withCnt(Integer cnt) {
        this.cnt = cnt;
        return this;
    }

    public java.util.List<com.sangchual.paytm.softwarechallenges.openweathermap.entity.daily.List> getList() {
        return list;
    }

    public void setList(java.util.List<com.sangchual.paytm.softwarechallenges.openweathermap.entity.daily.List> list) {
        this.list = list;
    }

    public DailyForecast withList(java.util.List<com.sangchual.paytm.softwarechallenges.openweathermap.entity.daily.List> list) {
        this.list = list;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("city", city).append("cod", cod).append("message", message).append("cnt", cnt).append("list", list).toString();
    }

}
