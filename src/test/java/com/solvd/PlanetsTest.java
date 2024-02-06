package com.solvd;

import com.zebrunner.carina.api.http.HttpResponseStatusType;
import domain.Planets;
import org.testng.annotations.Test;

public class PlanetsTest {

    @Test
    public void getPlanetsNameDetails(){
        Planets planets = new Planets();
        planets.setPlanetName("Neptune");
        GetPlanetDetailByName getPlanetDetailByName = new GetPlanetDetailByName(planets.getPlanetName());
        getPlanetDetailByName.addProperty("planets",planets);
        getPlanetDetailByName.expectResponseStatus(HttpResponseStatusType.OK_200);
        getPlanetDetailByName.callAPI();
        getPlanetDetailByName.validateResponse();
    }
}
