package org.testautomation;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testautomation.core.environment.Environment;

public abstract class BaseAPITest extends BaseTest {

    @BeforeSuite(groups = "api.test.example", dependsOnMethods = "setupEnvironment")
    public void setupAPIClientEnvironment() {
        RestAssured.baseURI = Environment.get("base.uri");
    }

}
