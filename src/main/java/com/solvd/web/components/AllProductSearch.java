package com.solvd.web.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class AllProductSearch extends AbstractUIObject {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(AllProductSearch.class);

    private WebElement searchProduct;

    private WebElement searchButton;

    public AllProductSearch(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AllProductSearch(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchProduct() {
        return searchProduct = driver.findElement(By.xpath("//input[@id='gh-ac']"));
    }

    public void typeSearchInputValues(String value) {
        searchProduct.sendKeys(value);
    }

    public List<WebElement> getAllProduct() {
        List<WebElement> allproduct = driver.findElements(By.xpath("//*[@id='srp-river-results']/ul/li"));
        Iterator<WebElement> iteratorAllProducts = allproduct.iterator();
        while (iteratorAllProducts.hasNext()) {
            WebElement product = iteratorAllProducts.next();
            LOGGER.info(product.getText());
            LOGGER.info(product.getTagName().contains("href"));
            LOGGER.info(product.getTagName().contains("img"));
            LOGGER.info("------------------------");
        }
        return allproduct;
    }

    public WebElement getSearchButton() {
        return searchButton = driver.findElement(By.xpath("//input[@id='gh-btn']"));
    }

    public void ClickSearchButton() {
        this.searchButton.click();
    }

}
