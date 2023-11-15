package org.testautomation.app.web;

import org.assertj.core.api.Assertions;
import org.testautomation.app.web.pages.LoginPage;
import org.testautomation.core.BaseWebTest;
import org.testautomation.core.constants.TestGroup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseWebTest {

    @Test(groups = TestGroup.WEB)
    public void verifyCanLoad() {
        var loginPage = new LoginPage().get();
        var title = loginPage.getTitle();
        Assertions.assertThat(title).isEqualTo("Swag Labs");
    }

    @Test(groups = TestGroup.WEB)
    public void verifyCanLogin() {
        var loginPage = new LoginPage().get();
        var productsPage = loginPage.loginValidUser("standard_user", "secret_sauce");

        Assertions.assertThat(productsPage.getTitle()).isEqualTo("Products");
    }

}
