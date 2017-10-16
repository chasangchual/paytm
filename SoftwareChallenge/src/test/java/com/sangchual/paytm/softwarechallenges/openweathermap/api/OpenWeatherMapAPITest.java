package com.sangchual.paytm.softwarechallenges.openweathermap.api;

import com.sangchual.paytm.softwarechallenges.openweathermap.entity.current.CurrentWeather;
import com.sangchual.paytm.softwarechallenges.openweathermap.entity.daily.DailyForecast;
import com.sangchual.paytm.softwarechallenges.openweathermap.entity.forecast.WeatherForecast;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OpenWeatherMapAPITest {
    private String city ;

    @Before
    public void initFixture() {
        city = "Oakville" ;
    }

    @Test
    // getCurrentWeather integration test
    public void getCurrentWeather() throws Exception {
        OpenWeatherMapAPI weatherMapAPI = OpenWeatherMapAPI.getInstance() ;
        CurrentWeather currentWeather = weatherMapAPI.getCurrentWeather(city) ;

        assertNotNull(currentWeather);
        for(com.sangchual.paytm.softwarechallenges.openweathermap.entity.current.Weather weather : currentWeather.getWeather()) {
            System.out.println(weather.toString()) ;
        }
    }

    @Test
    // getWeatherForecase integration test
    public void getWeatherForecast() throws Exception {
        OpenWeatherMapAPI weatherMapAPI = OpenWeatherMapAPI.getInstance() ;
        WeatherForecast weatherForecast = weatherMapAPI.getForecast(city) ;

        assertNotNull(weatherForecast);

        for(com.sangchual.paytm.softwarechallenges.openweathermap.entity.forecast.List list : weatherForecast.getList()) {
            System.out.println(list.toString()) ;
            System.out.println(list.getMain().toString()) ;
            for(com.sangchual.paytm.softwarechallenges.openweathermap.entity.forecast.Weather weather : list.getWeather()) {
                System.out.println(weather.toString()) ;
            }
        }
    }

    @Test
    // getDailyForecast integration test
    public void getDailyForecastt() throws Exception {
        OpenWeatherMapAPI weatherMapAPI = OpenWeatherMapAPI.getInstance() ;
        DailyForecast dailyForecast = weatherMapAPI.getDailyForecast(city) ;

        assertNotNull(dailyForecast);

        for(com.sangchual.paytm.softwarechallenges.openweathermap.entity.daily.List list : dailyForecast.getList()) {
            System.out.println(list.toString()) ;
            for(com.sangchual.paytm.softwarechallenges.openweathermap.entity.daily.Weather weather : list.getWeather()) {
                System.out.println(weather.toString()) ;
            }
        }
    }

}