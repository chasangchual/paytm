package com.sangchual.paytm.softwarechallenges.openweathermap.api;

import com.sangchual.paytm.softwarechallenges.openweathermap.entity.daily.DailyForecast;
import com.sangchual.paytm.softwarechallenges.openweathermap.entity.forecast.WeatherForecast;
import com.sangchual.paytm.softwarechallenges.openweathermap.entity.current.CurrentWeather ;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Call ;

public interface OpenWeatherMapService {

    // http://api.openweathermap.org/data/2.5/weather?q=Oakville,%20ON,%20Canada&appid=3cd3c05dc4ff13ba9967374dfd7ed852
    @GET ("/data/2.5/weather")
    Call<CurrentWeather> getCurrent(@Query("q") String name, @Query("appid") String appid) ;

    // http://api.openweathermap.org/data/2.5/forecast?q=Oakville,%20ON,%20Canada&appid=3cd3c05dc4ff13ba9967374dfd7ed852
    @GET ("/data/2.5/forecast")
    Call<WeatherForecast> getForecast(@Query("q") String name, @Query("appid") String appid) ;

    // http://api.openweathermap.org/data/2.5/forecast/daily?q=Oakville,%20ON,%20Canada&appid=3cd3c05dc4ff13ba9967374dfd7ed852
    @GET ("/data/2.5/forecast/daily")
    Call<DailyForecast> getDailyForecast(@Query("q") String name, @Query("appid") String appid) ;

}