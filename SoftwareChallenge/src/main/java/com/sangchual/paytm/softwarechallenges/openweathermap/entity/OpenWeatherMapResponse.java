package com.sangchual.paytm.softwarechallenges.openweathermap.entity;

import com.sangchual.paytm.softwarechallenges.openweathermap.entity.current.CurrentWeather;
import com.sangchual.paytm.softwarechallenges.openweathermap.entity.daily.DailyForecast;
import com.sangchual.paytm.softwarechallenges.openweathermap.entity.forecast.WeatherForecast;
import lombok.Getter;
import lombok.Setter;

public class OpenWeatherMapResponse {
    @Getter
    @Setter
    CurrentWeather currentWeather ;
    @Getter
    @Setter
    WeatherForecast weatherForecast ;
    @Getter
    @Setter
    DailyForecast dailyForecast ;
}
