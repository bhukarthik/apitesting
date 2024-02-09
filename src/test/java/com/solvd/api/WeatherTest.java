package com.solvd.api;

import com.solvd.api.GetWeatherByCity;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import domain.Weather;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WeatherTest {

    Weather weather= new Weather();
    @BeforeTest
    public void setup(){
        String city="Chennai";
        weather.setCity(city);
    }
    @Test
    public void getWeatherByCity(){
        GetWeatherByCity getWeatherByCity = new GetWeatherByCity(weather.getCity());
        getWeatherByCity.addProperty("weather",weather);
        getWeatherByCity.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherByCity.callAPI();
        getWeatherByCity.validateResponse();

    }
}
