package org.testautomation.core;

import io.restassured.RestAssured;
import org.testautomation.core.constants.Configuration;
import org.testautomation.core.constants.TestGroup;
import org.testng.annotations.BeforeSuite;
import org.testautomation.core.environment.Environment;

public abstract class BaseAPITest extends BaseTest {

    @BeforeSuite(groups = TestGroup.API, dependsOnMethods = "setupEnvironment")
    public void setupAPIClientEnvironment() {
        RestAssured.baseURI = Environment.get(Configuration.API_BASE_URI);
    }

}
