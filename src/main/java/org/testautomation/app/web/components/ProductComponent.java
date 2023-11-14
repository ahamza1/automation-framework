package org.testautomation.app.web.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testautomation.core.ui.BaseComponent;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductComponent extends BaseComponent {
    @FindBy(className = "inventory_item_name")
    private WebElement nameText;

    @FindBy(className = "inventory_item_price")
    private WebElement priceText;

    @FindBy(className = "add-to-cart-backpack")
    private WebElement addToCartButton;


    public ProductComponent(WebElement root) {
        super(root);
    }

    public String getName() {
        return nameText.getText();
    }

    public BigDecimal getPrice() {
        return new BigDecimal(
                priceText.getText().replace("$", "")
        ).setScale(2, RoundingMode.UNNECESSARY);
    }

    public void addToCart() {
        addToCartButton.click();
    }
}
