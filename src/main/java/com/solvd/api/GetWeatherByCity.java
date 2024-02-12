package com.solvd.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.utils.config.Configuration;

public class GetWeatherByCity extends AbstractApiMethodV2 {


    public GetWeatherByCity(String city) {
        super(null, "api.test/get_weather_rs.json");
        replaceUrlPlaceholder("base_url1", Configuration.getRequired("api_url1"));
        String apiKey = Configuration.getRequired("api_key");
        replaceUrlPlaceholder("city", city);
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
        addUrlParameter("X-Api-key", apiKey);
    }
}
