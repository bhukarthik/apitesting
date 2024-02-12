package com.solvd.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;


public class ProductComponents extends AbstractUIObject {
    public ProductComponents(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id='gh-p-4']/a[contains(text(),'Brand Outlet')]")
    private ExtendedWebElement brandedProductsLink;

    @FindBy(xpath ="//*[@id='s0-17-12-0-1[0]-0-0-0-27[3]-0-toggle-button']/span")
    private ExtendedWebElement productWatches;

    @FindBy(xpath = "//a[contains(text(),'Rolex')]")
    private ExtendedWebElement watchRolex;

    @FindBy(xpath = "//*[contains(text(),'2,452 Results')]")
    private ExtendedWebElement resultCheck;

    private List<WebElement> topCatagory;


    public List<WebElement> getTopCatagory() {

        return topCatagory;
    }
    public int getTopCatagoryNames(){
        Select categorySelect =  new Select(driver.findElement(By.xpath("//*[@id='gh-cat']")));
        Iterator<WebElement> iteratorAllCategories = categorySelect.getOptions().iterator();
        String topcategory= null;
        int total =0;
        while (iteratorAllCategories.hasNext()){
            WebElement products = iteratorAllCategories.next();
             topcategory= products.getText();
             total++;
        }
        return total;
    }

    public ExtendedWebElement getBrandedProductsLink() {
        return brandedProductsLink;
    }
    public ExtendedWebElement getProductWatches() {
        return productWatches;
    }

    public ExtendedWebElement getWatchRolex() {
        return watchRolex;
    }

    public ExtendedWebElement getResultCheck() {
        return resultCheck;
    }
    public void clickBrandedLink(){
        this.brandedProductsLink.click();
    }
    public void clickWatchesLink(){
        this.productWatches.click();
    }
    public void selectWatchRolex(){
        this.watchRolex.click();
    }
    public String checkResultCount(){
        return resultCheck.getText();
    }
}
