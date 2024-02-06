package com.solvd;

import com.zebrunner.carina.api.http.HttpResponseStatusType;
import domain.ZipCode;
import org.testng.annotations.Test;

public class StateCityTest {

    @Test
    public void VerifyZipCodeByStateAndCity(){
    ZipCode zipCode = new ZipCode();
    zipCode.setState("NC");
    zipCode.setCity("Angier");
    GetZipCodeByStateAndCity getZipCodeByStateAndCity = new GetZipCodeByStateAndCity(zipCode.getState(), zipCode.getCity());
    getZipCodeByStateAndCity.addProperty("zipCode",zipCode);
    getZipCodeByStateAndCity.expectResponseStatus(HttpResponseStatusType.OK_200);
    getZipCodeByStateAndCity.callAPI();
    getZipCodeByStateAndCity.validateResponse();

    }
}
