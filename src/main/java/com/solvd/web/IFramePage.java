package com.solvd.web;

import com.solvd.web.components.IFrameHeader;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class IFramePage extends AbstractPage {

    private IFrameHeader iFrameHeader;

    public IFramePage(WebDriver driver) {
        super(driver);
    }

    public IFrameHeader getiFrameHeader() {
        return iFrameHeader;
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("iframe_url"));
    }
}
