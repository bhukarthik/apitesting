package com.solvd.api;

import com.zebrunner.carina.api.http.HttpResponseStatusType;
import domain.Planets;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PlanetsTest {

    Planets planets = new Planets();

    @BeforeTest
    public void setup() {
        String name = "Neptune";
        planets.setPlanetName(name);

    }

    @Test
    public void getPlanetsNameDetails() {
        GetPlanetDetailByName getPlanetDetailByName = new GetPlanetDetailByName(planets.getPlanetName());
        getPlanetDetailByName.addProperty("planets", planets);
        getPlanetDetailByName.expectResponseStatus(HttpResponseStatusType.OK_200);
        getPlanetDetailByName.callAPI();
        getPlanetDetailByName.validateResponse();
    }
}
