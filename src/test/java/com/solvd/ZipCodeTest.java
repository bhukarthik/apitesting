package com.solvd;

import com.zebrunner.carina.api.http.HttpResponseStatusType;
import domain.ZipCode;
import org.testng.annotations.Test;

public class ZipCodeTest {
    @Test
    public void verifyCityByZipCode(){
        ZipCode zipCode = new ZipCode();
        zipCode.setZipCode("84020");
        GetCityByZipCode getCityByZipCode = new GetCityByZipCode(zipCode.getZipCode());
        getCityByZipCode.addProperty("zipCode",zipCode);
        getCityByZipCode.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCityByZipCode.callAPI();
        getCityByZipCode.validateResponse();
    }
}
