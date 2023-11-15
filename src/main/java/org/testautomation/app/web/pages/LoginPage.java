package org.testautomation.app.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testautomation.core.constants.Configuration;
import org.testautomation.core.driver.DriverFactory;
import org.testautomation.core.environment.Environment;
import org.testautomation.core.ui.BasePage;

/**
 * Page Object encapsulates the Log-in page.
 */
public class LoginPage extends BasePage<LoginPage> {
    @FindBy(className = "login_logo")
    private WebElement titleText;

    @FindBy(id = "user-name")
    private WebElement usernameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @Override
    public void load() {
        DriverFactory.getDriver().get(Environment.get(Configuration.WEB_BASE_URI));
    }

    public String getTitle() {
        return titleText.getText();
    }

    public ProductsPage loginValidUser(String userName, String password) {
        usernameInputField.sendKeys(userName);
        passwordInputField.sendKeys(password);
        loginButton.click();
        return new ProductsPage();
    }
}
