package ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    WebDriver driver;

    // Constructor
    public CheckoutPage(WebDriver driver) {

        this.driver = driver;
    }

    // Locators
    By checkoutButton = By.id("checkout");

    By firstName = By.id("first-name");

    By lastName = By.id("last-name");

    By postalCode = By.id("postal-code");

    By continueButton = By.id("continue");

    By finishButton = By.id("finish");

    By itemPrices =
            By.className("inventory_item_price");

    By itemTotal =
            By.className("summary_subtotal_label");

    By confirmationMessage =
            By.className("complete-header");

    // Open checkout
    public void clickCheckout() {

        driver.findElement(checkoutButton)
                .click();
    }

    // Enter checkout info
    public void enterCheckoutInfo(
            String fName,
            String lName,
            String zip) {

        driver.findElement(firstName)
                .sendKeys(fName);

        driver.findElement(lastName)
                .sendKeys(lName);

        driver.findElement(postalCode)
                .sendKeys(zip);
    }

    // Continue checkout
    public void clickContinue() {

        driver.findElement(continueButton)
                .click();
    }

    // Finish order
    public void clickFinish() {

        driver.findElement(finishButton)
                .click();
    }

    // Calculate item total
    public double calculateItemTotal() {

        List<WebElement> prices =
                driver.findElements(itemPrices);

        double total = 0;

        for (WebElement price : prices) {

            String priceText =
                    price.getText()
                            .replace("$", "");

            total += Double.parseDouble(priceText);
        }

        return total;
    }

    // Get displayed total
    public double getDisplayedItemTotal() {

        String totalText =
                driver.findElement(itemTotal)
                        .getText();

        totalText =
                totalText.replace("Item total: $", "");

        return Double.parseDouble(totalText);
    }

    // Get confirmation message
    public String getConfirmationMessage() {

        return driver.findElement(confirmationMessage)
                .getText();
    }
}