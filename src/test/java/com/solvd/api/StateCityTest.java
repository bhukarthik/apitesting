package com.solvd.api;

import com.zebrunner.carina.api.http.HttpResponseStatusType;
import domain.ZipCode;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StateCityTest {

    ZipCode zipCode = new ZipCode();

    @BeforeTest
    public void setup() {
        String state = "NC";
        String city = "Angier";
        zipCode.setState(state);
        zipCode.setCity(city);
    }

    @Test
    public void VerifyZipCodeByStateAndCity() {
        GetZipCodeByStateAndCity getZipCodeByStateAndCity = new GetZipCodeByStateAndCity(zipCode.getState(), zipCode.getCity());
        getZipCodeByStateAndCity.addProperty("zipCode", zipCode);
        getZipCodeByStateAndCity.expectResponseStatus(HttpResponseStatusType.OK_200);
        getZipCodeByStateAndCity.callAPI();
        getZipCodeByStateAndCity.validateResponse();

    }
}
