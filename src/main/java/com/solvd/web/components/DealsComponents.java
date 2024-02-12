package com.solvd.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DealsComponents extends AbstractUIObject {
    public DealsComponents(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id='gh-p-1']/a[contains(text(),'Daily Deals')]")
    private ExtendedWebElement productDeallLink;

    @FindBy(xpath ="//*[@class='dne-itemtile-price__see-all']")
    private ExtendedWebElement productTrendingDeal;

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
