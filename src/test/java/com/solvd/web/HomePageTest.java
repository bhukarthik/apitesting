package com.solvd.web;

import com.solvd.web.components.SearchLineComponents;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends AbstractTest {

    @DataProvider(name = "queryString")
    public static Object[][] queryString() {
        return new Object[][]{
                {"Speakers"},
        };
    }

    @DataProvider(name = "TotalString")
    public static Object[][] totalString() {
        return new Object[][]{
                {"23"},
        };
    }

    @Test
    public void verifyURL() {
        WebDriver webDriver = getDriver();
        HomePage page = new HomePage(webDriver);
        page.open();
        SearchLineComponents searchLineComponents = page.getHeader().getSearchLineComponents();
        SoftAssert sa = new SoftAssert();
        String actualurl = Configuration.getRequired("home_url");
        sa.assertEquals(webDriver.getCurrentUrl(), actualurl, "Actual url does not match expected.");
    }

    @Test(dataProvider = "queryString")
    public void verifySearchLineTest(String queryString) {
        WebDriver webDriver = getDriver();
        HomePage page = new HomePage(webDriver);
        page.open();
        SearchLineComponents searchLineComponents = page.getHeader().getSearchLineComponents();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(searchLineComponents.getProductTypesSelect().isElementPresent(2), "Search is not working");
        sa.assertTrue(searchLineComponents.getSearchButton().isElementPresent(2), "Button is not working");
        searchLineComponents.typeSearchInputValues(queryString);
        searchLineComponents.clickSearchButton();
        sa.assertAll();
    }

    @Test(dataProvider = "queryString")
    public void verifyCategoryOption(String queryString) {
        WebDriver webDriver = getDriver();
        HomePage page = new HomePage(webDriver);
        page.open();
        SearchLineComponents searchLineComponents = page.getHeader().getSearchLineComponents();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(searchLineComponents.getProductTypesSelect().isElementPresent(2), "Search is not working");
        sa.assertTrue(searchLineComponents.getSearchButton().isElementPresent(2), "Button is not working");
        searchLineComponents.typeSearchInputValues(queryString);
        searchLineComponents.findCategory();
        searchLineComponents.clickSearchButton();
        sa.assertAll();
    }

    @Test(dataProvider = "TotalString")
    void verifyCertifiedTotalRefurbishedItems(String total) {
        WebDriver webDriver = getDriver();
        HomePage page = new HomePage(webDriver);
        page.open();
        SearchLineComponents searchLineComponents = new SearchLineComponents(webDriver);
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(searchLineComponents.getRefurbished().isElementNotPresent(1), "Refurbished page is not present");
        sa.assertTrue(searchLineComponents.getCertifiedRefurbished().isElementNotPresent(1), "Certified refurbished is not present");
        sa.assertEquals(searchLineComponents.findTotalCertifiedItems(), total);
        searchLineComponents.clickRefurbishedPage();
        searchLineComponents.ClickCertifiedRefurbishedPage();
        searchLineComponents.findTotalCertifiedItems();
        sa.assertAll();
    }

    @Test
    public void verifyListView() {
        WebDriver webDriver = getDriver();
        HomePage page = new HomePage(webDriver);
        page.open();
        SearchLineComponents searchLineComponents = new SearchLineComponents(webDriver);
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(searchLineComponents.getRefurbished().isElementNotPresent(1), "Refurbished page is not present");
        sa.assertTrue(searchLineComponents.getCertifiedRefurbished().isElementNotPresent(1), "Certified refurbished is not");
        sa.assertTrue(searchLineComponents.getListView().isElementNotPresent(1), "List view is not present");
        searchLineComponents.clickRefurbishedPage();
        searchLineComponents.ClickCertifiedRefurbishedPage();
        searchLineComponents.clickListView();
        sa.assertAll();
    }
}


