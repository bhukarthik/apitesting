package com.solvd.web;

import com.solvd.web.components.DealsComponents;
import com.solvd.web.components.ProductComponents;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DealsPageTest extends AbstractTest {

    @DataProvider(name = "queryString")
    public static Object[][] queryString() {
        return new Object[][]{
                {"2,452 Results"}
        };
    }

    @DataProvider(name = "queryInput")
    public static Object[][] queryInput() {
        return new Object[][]{
                {"Gift Cards"}
        };
    }

    @Test
    public void verifyDealsTest() {
        WebDriver webDriver = getDriver();
        DealsPage dealsPage = new DealsPage(webDriver);
        dealsPage.open();
        SoftAssert sa = new SoftAssert();
        DealsComponents dealsComponents = new DealsComponents(webDriver);
        sa.assertTrue(dealsComponents.getProductDeallLink().isElementPresent(1), "Deals link page is not present");
        sa.assertTrue(dealsComponents.getProductTrendingDeal().isElementNotPresent(1), "Top Deals page is not present");
        dealsComponents.clickDealsPage();
        dealsComponents.checkTrendingDeals();
        sa.assertAll();
    }

    @Test(dataProvider = "queryString")
    public void verifyBrandedWatched(String results) {
        WebDriver webDriver = getDriver();
        DealsPage dealsPage = new DealsPage(webDriver);
        dealsPage.open();
        SoftAssert sa = new SoftAssert();
        ProductComponents productComponents = new ProductComponents(webDriver);
        sa.assertTrue(productComponents.getBrandedProductsLink().isElementPresent(1), "Braded link not present");
        sa.assertTrue(productComponents.getProductWatches().isElementNotPresent(1), "Unable to select watch filter");
        sa.assertTrue(productComponents.getProductWatches().isElementNotPresent(1), "Watch Rolex not availalble");
        sa.assertEquals(results, productComponents.checkResultCount());
        productComponents.clickBrandedLink();
        productComponents.clickWatchesLink();
        productComponents.selectWatchRolex();
        sa.assertAll();
    }

    @Test
    public void verifyTotalCategoriesList() {
        WebDriver webDriver = getDriver();
        DealsPage dealsPage = new DealsPage(webDriver);
        dealsPage.open();
        SoftAssert sa = new SoftAssert();
        ProductComponents productComponents = new ProductComponents(webDriver);
        productComponents.getTopCatagoryNames();
        sa.assertEquals(productComponents.getTopCatagoryNames(), 36);
        sa.assertAll();
    }

    @Test(dataProvider = "queryInput")
    public void verfiyTodaysDeal(String input) {
        WebDriver webDriver = getDriver();
        DealsPage dealsPage = new DealsPage(webDriver);
        dealsPage.open();
        SoftAssert sa = new SoftAssert();
        DealsComponents dealsComponents = new DealsComponents(webDriver);
        sa.assertFalse(dealsComponents.clickMyId(input), "Gift card Page is working");
        dealsComponents.clickMyId(input);
        sa.assertAll();
    }
}
