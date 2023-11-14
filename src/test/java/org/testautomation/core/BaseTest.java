package org.testautomation.core;

import org.testautomation.core.environment.Environment;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

//@Listeners(TestListener.class)
public abstract class BaseTest {

    @Parameters("env")
    @BeforeSuite(alwaysRun = true)
    public void setupEnvironment(@Optional(value = "desktop.chrome") String env) {
        Environment.setEnvironment(env);
    }

}
