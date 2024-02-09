package com.solvd.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.utils.config.Configuration;

public class GetCityByZipCode extends AbstractApiMethodV2 {


    public GetCityByZipCode(String zipCode) {
        super(null, "api.test/get_city_rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("zipCode", String.valueOf(zipCode));

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }

}
