package ui.pages;

import java.util.List;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    WebDriver driver;

    // Constructor
    public CartPage(WebDriver driver) {

        this.driver = driver;
    }

    // Locators
    By cartBadge = By.className("shopping_cart_badge");

    By cartLink = By.className("shopping_cart_link");

    By cartItems = By.className("inventory_item_name");

    By removeButton =
            By.id("remove-sauce-labs-bike-light");

    // Get cart badge count
    public String getCartBadgeCount() {

        return driver.findElement(cartBadge)
                .getText();
    }

    // Open cart
    public void openCart() {

        driver.findElement(cartLink)
                .click();
    }

    // Remove item
    public void removeItem() {

        driver.findElement(removeButton)
                .click();

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(5));

        wait.until(
                ExpectedConditions.textToBePresentInElementLocated(
                        cartBadge,
                        "2"));
    }
    
    
    // Get cart item names
    public List<WebElement> getCartItems() {

        return driver.findElements(cartItems);
    }

    // Verify removed item absent
    public boolean isItemPresent(String itemName) {

        List<WebElement> items =
                getCartItems();

        for (WebElement item : items) {

            if (item.getText()
                    .equals(itemName)) {

                return true;
            }
        }

        return false;
    }
}