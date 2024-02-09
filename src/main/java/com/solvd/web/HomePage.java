package com.solvd.web;

import com.solvd.web.components.Header;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import domain.Weather;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractUIObject {

    private Header header;
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public Header getHeader() {
        return header;
    }
    @Override
    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }
}
