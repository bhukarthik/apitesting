package com.solvd;

import com.zebrunner.carina.api.http.HttpResponseStatusType;
import domain.Weather;
import org.testng.annotations.Test;

public class WeatherTest {

    @Test
    public void getWeatherByCity(){
        Weather weather= new Weather();
        weather.setCity("Chennai");
        GetWeatherByCity getWeatherByCity = new GetWeatherByCity(weather.getCity());
        getWeatherByCity.addProperty("weather",weather);
        getWeatherByCity.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherByCity.callAPI();
        getWeatherByCity.validateResponse();

    }
}
