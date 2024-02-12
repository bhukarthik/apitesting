package com.solvd.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;

public class SearchLineComponents extends AbstractUIObject {
    @FindBy(xpath = "//input[@id='gh-ac']")
    private ExtendedWebElement productTypesSelect;

    @FindBy(xpath ="//input[@id='gh-btn']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//*[@id='vl-flyout-nav']/ul/li[13]/a")
    private ExtendedWebElement refurbished;

    @FindBy(xpath = "//*[@id='s0-17-12-0-1[0]-0-0-0']/ul/li[1]/a")
    private ExtendedWebElement certifiedRefurbished;
    private WebElement checkCategory;

    @FindBy(xpath = "//*[@class='icon icon--list-view-24']/*")
    private ExtendedWebElement listView;


    public int findTotalCertifiedItems(){
        Select categorySelect =  new Select(driver.findElement(By.xpath("//*[@class='s-item__link']/h3/text()")));
        Iterator<WebElement> iteratorAllCategories = categorySelect.getOptions().iterator();
        String topcategory= null;
        int total =0;
        while (iteratorAllCategories.hasNext()){
            WebElement products = iteratorAllCategories.next();
            topcategory= products.getText();
            total++;
        }
        System.out.println("Total " +total);
        return total;
    }
    public void findCategory(){
        try{
            Select categorySelect =  new Select(driver.findElement(By.xpath("//*[@id='gh-cat']")));
            categorySelect.selectByVisibleText("Music");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public ExtendedWebElement getRefurbished() {
        return refurbished;
    }
    public void clickRefurbishedPage(){
        this.refurbished.click();

    }
    public ExtendedWebElement getCertifiedRefurbished() {
        return certifiedRefurbished;
    }
    public void ClickCertifiedRefurbishedPage(){
        this.certifiedRefurbished.click();
    }
    public WebElement getCheckCategory() {
        return checkCategory;
    }
    public ExtendedWebElement getListView() {
        return listView;
    }
    public void clickListView(){
        listView.click();
    }
    public SearchLineComponents(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public SearchLineComponents(WebDriver driver) {
        super(driver);
    }
    public ExtendedWebElement getProductTypesSelect() {
        return productTypesSelect;
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }
    public void clickSearchButton(){
        this.searchButton.click();
    }
    public void typeSearchInputValues(String value){
        productTypesSelect.type(value);
    }
}
