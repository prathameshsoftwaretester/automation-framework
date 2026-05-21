package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ui.base.BaseTest;
import ui.pages.InventoryPage;
import ui.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        // Login
        loginPage.login(
                "standard_user",
                "secret_sauce");

        // Verify URL
        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("inventory.html"));

        // Verify title
        Assert.assertTrue(
                inventoryPage.isTitleDisplayed());

        // Verify product count
        int productCount =
                inventoryPage.getProductCount();

        System.out.println(
                "Product Count: " + productCount);

        Assert.assertTrue(productCount > 0);

        // Verify cart visible
        Assert.assertTrue(
                inventoryPage.isCartVisible());

        System.out.println("TC-01 Passed");
    }
}