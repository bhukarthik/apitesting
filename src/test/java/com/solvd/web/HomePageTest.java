package com.solvd.web;

import com.solvd.web.components.SearchLineComponents;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class HomePageTest extends AbstractTest {

    @DataProvider(name = "queryString")
    public static Object[][] queryString() {
        return new Object[][]{
                {"speakers"},
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
    public void verifySearchLineTest(String queryString) throws InterruptedException {
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

    @Test
    public void verifyNewTab() {
        WebDriver webDriver = getDriver();
        HomePage page = new HomePage(webDriver);
        page.open();
        webDriver.switchTo().newWindow(WindowType.TAB);
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1)); //switches to new tab
        String newTabUrl = String.valueOf(webDriver.switchTo().window(tabs.get(1)));
        webDriver.get(page.getCurrentUrl());
        webDriver.switchTo().window(tabs.get(0)); // switch back to main screen
        SoftAssert sa = new SoftAssert();
        String actualurl = Configuration.getRequired("home_url");
        sa.assertEquals(newTabUrl, actualurl, "url does not match expected.");
    }

    @Test(dataProvider = "queryString")
    public void verifySearchSuggestions(String query) throws InterruptedException {
        WebDriver webDriver = getDriver();
        HomePage page = new HomePage(webDriver);
        page.open();
        SearchLineComponents searchLineComponents = page.getHeader().getSearchLineComponents();
        SoftAssert sa = new SoftAssert();
        String searchValue = searchLineComponents.checkSearchSelection(query);
        sa.assertEquals(query, searchValue);
        sa.assertAll();
    }
}


