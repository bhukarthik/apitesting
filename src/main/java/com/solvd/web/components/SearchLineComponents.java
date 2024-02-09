package com.solvd.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchLineComponents extends AbstractUIObject {
    @FindBy(xpath = "//input[@id='gh-ac']")
    private ExtendedWebElement productTypesSelect;

    @FindBy(xpath ="//input[@id='gh-btn']")
    private ExtendedWebElement searchButton;

    public SearchLineComponents(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getProductTypesSelect() {
        return productTypesSelect;
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }
    public void clickSearchButton(){
        searchButton.click();
    }
    public void typeSearchInputValues(String value){
        searchButton.sendKeys(value);
    }
}
