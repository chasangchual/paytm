package com.sangchual.paytm.softwarechallenges.openweathermap;

import com.sangchual.paytm.softwarechallenges.exception.InvalidUserRequestException;
import com.sangchual.paytm.softwarechallenges.openweathermap.api.OpenWeatherMapAPI;
import com.sangchual.paytm.softwarechallenges.openweathermap.entity.OpenWeatherMapResponse;
import com.sangchual.paytm.softwarechallenges.openweathermap.entity.current.CurrentWeather;
import com.sangchual.paytm.softwarechallenges.utils.AuthTokenManager;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {
    /**
     * http://localhost:8080/service/v1/weather?city=Toronto
     * @param city
     * @return
     */
    @RequestMapping(value = "/service/v1/weather", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public OpenWeatherMapResponse sayHelloWorld(@RequestParam("city") String city, @RequestParam("email") String email, @RequestParam("authtoken") String authToken ) {

        if(AuthTokenManager.getInstance().validateAuthToken(email, authToken)) {
            OpenWeatherMapAPI weatherMapAPI = OpenWeatherMapAPI.getInstance() ;
            OpenWeatherMapResponse responseOpenWeatherMap = new OpenWeatherMapResponse() ;

            CurrentWeather currentWeather = weatherMapAPI.getCurrentWeather(city) ;

            responseOpenWeatherMap.setCurrentWeather(weatherMapAPI.getCurrentWeather(city) );
            responseOpenWeatherMap.setWeatherForecast(weatherMapAPI.getForecast(city));
            responseOpenWeatherMap.setDailyForecast(weatherMapAPI.getDailyForecast(city));

            // TO-DO handling exception

            return responseOpenWeatherMap ;
        } else {
            throw new InvalidUserRequestException("invalid auth token passed.") ;
        }
    }
}