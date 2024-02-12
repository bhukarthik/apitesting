package com.solvd.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.utils.config.Configuration;

public class GetPlanetDetailByName extends AbstractApiMethodV2 {

    public GetPlanetDetailByName(String planetName) {
        super(null, "api.test/get_planet_properties_rs.json");
        replaceUrlPlaceholder("base_url1", Configuration.getRequired("api_url1"));
        String apiKey = Configuration.getRequired("api_key");
        replaceUrlPlaceholder("planetName", planetName);
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
        addUrlParameter("X-Api-key", apiKey);
    }
}
