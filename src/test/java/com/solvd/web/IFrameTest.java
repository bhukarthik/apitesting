package com.solvd.web;

import com.solvd.web.components.IFrameComponents;
import com.solvd.web.components.SearchLineComponents;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class IFrameTest extends AbstractTest {
    @Test
    public void verifyIframeURL() {
        WebDriver webDriver = getDriver();
        IFramePage page = new IFramePage(webDriver);
        page.open();
        IFrameComponents iFrameComponents = page.getiFrameHeader().getFrameComponents();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(iFrameComponents.getIframe().isDisplayed(), "Iframe Visible");
        iFrameComponents.getIframe();
        iFrameComponents.switchIframe();
        sa.assertAll();
    }
}
