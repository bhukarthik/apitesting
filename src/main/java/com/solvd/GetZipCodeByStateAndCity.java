package com.solvd;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.utils.config.Configuration;

public class GetZipCodeByStateAndCity extends AbstractApiMethodV2 {
    public GetZipCodeByStateAndCity(String state, String city) {
        super(null, "api.zipcode/get_zipcode_rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("state", state);
        replaceUrlPlaceholder("city", city);
        ignorePropertiesProcessor(NotStringValuesProcessor.class);

    }
}
