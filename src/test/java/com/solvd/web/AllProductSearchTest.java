package com.solvd.web;

import com.solvd.web.components.AllProductSearch;
import com.solvd.web.components.SearchLineComponents;
import com.zebrunner.carina.core.AbstractTest;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AllProductSearchTest extends AbstractTest {

    @DataProvider(name = "queryString")
    public static Object[][] queryString() {
        return new Object[][]{
                {"ultra wet grinder"},
        };
    }

    @Description("Implement 1 Test which will take list of UI objects and check each element in this list on presenting of text, images and buttons. then check if all links in terms of element are working correctly.")
    @Test(dataProvider = "queryString")
    public void verifyAllProductTest(String queryString) {
        WebDriver webDriver = getDriver();
        HomePage page = new HomePage(webDriver);
        page.open();
        AllProductSearch allProductSearch = new AllProductSearch(webDriver);
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(allProductSearch.getSearchProduct().isDisplayed(), "Search is not working");
        sa.assertTrue(allProductSearch.getSearchButton().isDisplayed(), "Button is not working");
        sa.assertTrue(allProductSearch.getAllProduct().isEmpty(), "Result elements is empty");
        allProductSearch.typeSearchInputValues(queryString);
        allProductSearch.ClickSearchButton();
        allProductSearch.getAllProduct();
        sa.assertAll();
    }
}
