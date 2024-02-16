package com.solvd.web.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class IFrameHeader extends AbstractUIObject {

    @FindBy(xpath = "//*[@id='app']/div[2]/div/header")
    private IFrameComponents frameComponents;

    public IFrameHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public IFrameComponents getFrameComponents() {
        return frameComponents;
    }
}
