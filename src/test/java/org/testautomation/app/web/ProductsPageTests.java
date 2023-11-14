package org.testautomation.app.web;

import org.assertj.core.api.Assertions;
import org.testautomation.app.web.pages.LoginPage;
import org.testautomation.core.BaseWebTest;
import org.testautomation.core.constants.TestGroup;
import org.testng.annotations.Test;

public class ProductsPageTests extends BaseWebTest {
    @Test(groups = TestGroup.WEB)
    public void testProductInventory() {
        var productsPage = LoginPage.navigate()
                .loginValidUser("standard_user", "secret_sauce");

        var products = productsPage.getProducts();

        Assertions.assertThat(6).isEqualTo(products.size());
    }
}
