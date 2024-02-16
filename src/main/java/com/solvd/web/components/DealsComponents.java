package com.solvd.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DealsComponents extends AbstractUIObject {
    public DealsComponents(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id='gh-p-1']/a[contains(text(),'Daily Deals')]")
    private ExtendedWebElement productDeallLink;

    private final String searchString = "//*[@id='gh-p-6']/a[contains(text(),'%s')]";


    @FindBy(xpath ="//*[@class='dne-itemtile-price__see-all']")
    private ExtendedWebElement productTrendingDeal;

    public WebElement idSelect(String text) {
        return driver.findElement(By.xpath(String.format(searchString,text)));
    }
    public boolean clickMyId(String text){
        idSelect(text).click();
        return false;
    }
    public ExtendedWebElement getProductDeallLink() {
        return productDeallLink;
    }

    public ExtendedWebElement getProductTrendingDeal() {
        return productTrendingDeal;
    }

    public void clickDealsPage(){
        this.productDeallLink.click();

    }
    public void checkTrendingDeals(){
            this.productTrendingDeal.click();
    }

}
