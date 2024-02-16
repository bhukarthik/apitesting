package com.solvd.web.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFrameComponents extends AbstractUIObject {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(IFrameComponents.class);
    @FindBy(xpath = "//iframe[@id='__JSBridgeIframe__']")
    private WebElement iframe;

    public IFrameComponents(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public WebElement getIframe() {
        return iframe;
    }

    public void switchIframe() {
        driver.findElement(By.xpath("/iframe[@id='__JSBridgeIframe__']"));
        driver.switchTo().frame(1);
        WebElement element = driver.findElement(By.xpath("//body"));
        LOGGER.info("Element " + element.getText());
        driver.close();
    }
}
