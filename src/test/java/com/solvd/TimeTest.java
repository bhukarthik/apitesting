package com.solvd;

import com.zebrunner.carina.api.http.HttpResponseStatusType;
import domain.Weather;
import org.testng.annotations.Test;

public class TimeTest {

    @Test
    void verifyTimebyCity(){
        Weather weather= new Weather();
        weather.setCity("Chennai");
        GetTimeByCity getTimeByCity = new GetTimeByCity(weather.getCity());
        getTimeByCity.addProperty("weather",weather);
        getTimeByCity.expectResponseStatus(HttpResponseStatusType.OK_200);
        getTimeByCity.callAPI();
        getTimeByCity.validateResponse();
    }
}
