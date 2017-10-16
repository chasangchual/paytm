package com.sangchual.paytm.softwarechallenges.openweathermap.api;

import com.sangchual.paytm.softwarechallenges.openweathermap.entity.current.CurrentWeather;
import com.sangchual.paytm.softwarechallenges.openweathermap.entity.daily.DailyForecast;
import com.sangchual.paytm.softwarechallenges.openweathermap.entity.forecast.WeatherForecast;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Slf4j
public class OpenWeatherMapAPI {
    final String baseUrl = "http://api.openweathermap.org" ;
    final String keyOpenWeatherMap = "3cd3c05dc4ff13ba9967374dfd7ed852" ;
    final String country = "ca" ;

    Retrofit retrofit = null ;
    OpenWeatherMapService service = null ;

    private static OpenWeatherMapAPI instance = null ;

    public synchronized static OpenWeatherMapAPI getInstance() {
        if(instance == null) {
            instance = new OpenWeatherMapAPI() ;
        }

        return instance ;
    }

    private OpenWeatherMapAPI() {
        retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build() ;

        service = retrofit.create(OpenWeatherMapService.class) ;
    }

    public CurrentWeather getCurrentWeather(String city)
    {
        CurrentWeather currentWeather = null ;

        try
        {
            Call<CurrentWeather> call = service.getCurrent(String.format("%s,%s", city, country), keyOpenWeatherMap) ;
            Response<CurrentWeather> response = call.execute() ;
            currentWeather = response.body() ;
        }
        catch (Exception e) {
            log.error("failed to call OpenWeatherMap API - getCurrentWeather()", e) ;
        }

        return  currentWeather ;
    }

    public WeatherForecast getForecast(String city) {
        WeatherForecast weatherForecast = null ;

        try
        {
            Call<WeatherForecast> call = service.getForecast(String.format("%s,%s", city, country), keyOpenWeatherMap) ;
            Response<WeatherForecast> response = call.execute() ;
            weatherForecast = response.body() ;
        }
        catch (Exception e) {
            log.error("failed to call OpenWeatherMap API - getForecast()", e) ;
        }

        return  weatherForecast ;
    }

    public DailyForecast getDailyForecast(String city) {
        DailyForecast dailyForecast = null ;

        try
        {
            Call<DailyForecast> call = service.getDailyForecast(String.format("%s,%s", city, country), keyOpenWeatherMap) ;
            Response<DailyForecast> response = call.execute() ;
            dailyForecast = response.body() ;
        }
        catch (Exception e) {
            log.error("failed to call OpenWeatherMap API - getDailyForecast()", e) ;
        }

        return  dailyForecast ;
    }

}
