package com.solvd.web.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    public SearchLineComponents getSearchLineComponents() {
        return searchLineComponents;
    }

    private SearchLineComponents searchLineComponents;
    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
