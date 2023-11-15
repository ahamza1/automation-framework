package org.testautomation.app.web;

import org.assertj.core.api.Assertions;
import org.testautomation.app.web.pages.LoginPage;
import org.testautomation.app.web.pages.ProductsPage;
import org.testautomation.core.BaseWebTest;
import org.testautomation.core.constants.TestGroup;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsPageTests extends BaseWebTest {

    @Override
    @BeforeMethod(groups = TestGroup.WEB)
    public void testSetup() {
        super.testSetup();

        LoginPage loginPage = new LoginPage().get();
        loginPage.loginValidUser("standard_user", "secret_sauce");
    }

    @Test(groups = TestGroup.WEB)
    public void testProductInventory() {
        var productsPage = new ProductsPage().get();
        var products = productsPage.getProducts();

        Assertions.assertThat(6).isEqualTo(products.size());
    }
}
