package org.testautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testautomation.core.driver.DriverFactory;
import org.testautomation.core.environment.Environment;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseUITest extends BaseTest {

    @BeforeMethod(groups = "ui.test.example")
    public void setupDriver() {
        String driver = Environment.get("driver");
        Map<String, Object> capabilities = Environment.getOrDefault(driver, new HashMap<>());
        DriverFactory.setDriver(driver, capabilities);

    }

    @AfterMethod(groups = "ui.test.example")
    public void quitDriver() {
        DriverFactory.quitDriver();
    }

}
