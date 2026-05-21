package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ui.base.BaseTest;
import ui.pages.CartPage;
import ui.pages.CheckoutPage;
import ui.pages.InventoryPage;
import ui.pages.LoginPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutValidationTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        CartPage cartPage =
                new CartPage(driver);

        CheckoutPage checkoutPage =
                new CheckoutPage(driver);

        // Login
        loginPage.login(
                "standard_user",
                "secret_sauce");

        // Add products
        inventoryPage.addBackpackToCart();

        inventoryPage.addBikeLightToCart();

        // Open cart
        cartPage.openCart();

        // Checkout
        checkoutPage.clickCheckout();

        // Enter user info
        checkoutPage.enterCheckoutInfo(
                "Test",
                "User",
                "12345");

        // Continue
        checkoutPage.clickContinue();

        // Calculate expected total
        double expectedTotal =
                checkoutPage.calculateItemTotal();

        // Get displayed total
        double actualTotal =
                checkoutPage.getDisplayedItemTotal();

        System.out.println(
                "Expected Total: " + expectedTotal);

        System.out.println(
                "Actual Total: " + actualTotal);

        // Verify totals match
        Assert.assertEquals(
                actualTotal,
                expectedTotal);

        // Finish order
        checkoutPage.clickFinish();

        // Verify confirmation
        String confirmation =
                checkoutPage.getConfirmationMessage();

        System.out.println(
                "Confirmation Message: "
                        + confirmation);

        Assert.assertEquals(
                confirmation,
                "Thank you for your order!");

        System.out.println("TC-05 Passed");
    }
}