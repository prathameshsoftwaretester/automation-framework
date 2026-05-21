package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ui.base.BaseTest;
import ui.pages.CartPage;
import ui.pages.InventoryPage;
import ui.pages.LoginPage;

public class CartTest extends BaseTest {

    @Test
    public void cartAddRemoveValidationTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        CartPage cartPage =
                new CartPage(driver);

        // Login
        loginPage.login(
                "standard_user",
                "secret_sauce");

        // Add 3 products
        inventoryPage.addBackpackToCart();

        inventoryPage.addBikeLightToCart();

        inventoryPage.addBoltShirtToCart();

        // Verify cart badge = 3
        String initialBadge =
                cartPage.getCartBadgeCount();

        System.out.println(
                "Initial Cart Badge: " + initialBadge);

        Assert.assertEquals(initialBadge, "3");

        // Open cart
        cartPage.openCart();

        // Remove Bike Light
        cartPage.removeItem();

        // Verify cart badge = 2
        String updatedBadge =
                cartPage.getCartBadgeCount();

        System.out.println(
                "Updated Cart Badge: " + updatedBadge);

        Assert.assertEquals(updatedBadge, "2");

        // Verify removed item absent
        boolean itemPresent =
                cartPage.isItemPresent(
                        "Sauce Labs Bike Light");

        Assert.assertFalse(itemPresent);

        System.out.println("TC-04 Passed");
    }
}