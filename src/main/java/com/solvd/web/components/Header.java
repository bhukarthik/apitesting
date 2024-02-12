package com.solvd.web.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(xpath = "//form[@id='gh-f']")
    private SearchLineComponents searchLineComponents;
    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public Header(WebDriver driver){
        super(driver);
    }
    public SearchLineComponents getSearchLineComponents() {
        return searchLineComponents;
    }



}
