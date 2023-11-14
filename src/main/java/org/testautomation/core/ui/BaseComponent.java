package org.testautomation.core.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testautomation.core.constants.Configuration;
import org.testautomation.core.driver.DriverFactory;
import org.testautomation.core.environment.Environment;

import java.time.Duration;

public class BaseComponent {
    private static final int WAIT_TIME_SECONDS = Environment.getOrDefault(Configuration.DRIVER_WAIT, 3);

    public BaseComponent(WebElement root) {
        if (DriverFactory.getDriver() instanceof AppiumDriver) {
            PageFactory.initElements(new AppiumFieldDecorator(
                    root, Duration.ofSeconds(WAIT_TIME_SECONDS)), this);
        } else {
            PageFactory.initElements(new AjaxElementLocatorFactory(
                    root, WAIT_TIME_SECONDS), this);
        }
    }
}
