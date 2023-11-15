package org.testautomation.core;

import org.testautomation.core.constants.Configuration;
import org.testautomation.core.constants.TestGroup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testautomation.core.driver.DriverFactory;
import org.testautomation.core.environment.Environment;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseWebTest extends BaseTest {

    @BeforeMethod(groups = TestGroup.WEB)
    public void testSetup() {
        String driver = Environment.get(Configuration.DRIVER);
        Map<String, Object> capabilities = Environment.getOrDefault(driver, new HashMap<>());
        DriverFactory.setDriver(driver, capabilities);
    }

    @AfterMethod(groups = TestGroup.WEB)
    public void testCleanup() {
        DriverFactory.quitDriver();
    }

}
