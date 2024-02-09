package com.solvd.web;

import com.solvd.web.components.SearchLineComponents;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends AbstractTest {

    @Test
    public void verifySearchLineTest(){

        SoftAssert sa = new SoftAssert();
        WebDriver webDriver = getDriver();
        HomePage page = new HomePage(webDriver);
        page.open();
        SearchLineComponents searchLineComponents = page.getHeader().getSearchLineComponents();
        sa.assertTrue(searchLineComponents.getProductTypesSelect().isElementNotPresent(1), "Search is not working");
        Assert.assertTrue(searchLineComponents.getSearchButton().isElementNotPresent(1),"Button is not working");

        searchLineComponents.typeSearchInputValues("oil");
        searchLineComponents.clickSearchButton();
    }
}
