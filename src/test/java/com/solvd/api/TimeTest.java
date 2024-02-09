package com.solvd.api;

import com.solvd.api.GetTimeByCity;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import domain.Weather;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TimeTest {

    Weather weather= new Weather();
    @BeforeTest
    public void setup(){
        String city="chennai";
        weather.setCity(city);
    }
    @Test
    void verifyTimebyCity(){
        GetTimeByCity getTimeByCity = new GetTimeByCity(weather.getCity());
        getTimeByCity.addProperty("weather",weather);
        getTimeByCity.expectResponseStatus(HttpResponseStatusType.OK_200);
        getTimeByCity.callAPI();
        getTimeByCity.validateResponse();
    }

}
