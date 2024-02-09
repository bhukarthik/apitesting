package com.solvd.api;

import com.solvd.api.GetCityByZipCode;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import domain.ZipCode;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ZipCodeTest {

    ZipCode zipCode = new ZipCode();
    @BeforeTest
    public void setup(){
        String zipcode="84020";
        zipCode.setZipCode(zipcode);

    }
    @Test
    public void verifyCityByZipCode(){
        GetCityByZipCode getCityByZipCode = new GetCityByZipCode(zipCode.getZipCode());
        getCityByZipCode.addProperty("zipCode",zipCode);
        getCityByZipCode.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCityByZipCode.callAPI();
        getCityByZipCode.validateResponse();
    }
}
