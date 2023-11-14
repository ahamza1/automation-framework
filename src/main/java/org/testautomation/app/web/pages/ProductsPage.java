package org.testautomation.app.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testautomation.app.web.components.ProductComponent;
import org.testautomation.core.ui.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Page Object encapsulates the Inventory page.
 */
public class ProductsPage extends BasePage {
    @FindBy(className = "title")
    private WebElement titleText;

    @FindBy(className = "inventory_item")
    private List<WebElement> products;

    public String getTitle() {
        return titleText.getText();
    }

    public List<ProductComponent> getProducts() {
        return products.stream()
                .map(ProductComponent::new) // Map WebElement to a product component
                .toList();
    }

    public ProductComponent getProduct(Predicate<ProductComponent> condition) {
        return getProducts()
                .stream()
                .filter(condition) // Filter by product name or price
                .findFirst()
                .orElseThrow();
    }
}
