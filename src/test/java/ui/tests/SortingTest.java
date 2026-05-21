package ui.tests;

import java.util.ArrayList;
import java.util.Collections;

import org.testng.Assert;
import org.testng.annotations.Test;

import ui.base.BaseTest;
import ui.pages.InventoryPage;
import ui.pages.LoginPage;

public class SortingTest extends BaseTest {

    @Test
    public void verifyLowToHighSorting() {

        LoginPage loginPage =
                new LoginPage(driver);

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        // Login
        loginPage.login(
                "standard_user",
                "secret_sauce");

        // Select low to high sorting
        inventoryPage.sortByLowToHigh();
        
        ArrayList<String> productNames =
                inventoryPage.getProductNames();

        System.out.println(
                "Product Names: " + productNames);

        // Capture actual prices
        ArrayList<Double> actualPrices =
                inventoryPage.getProductPrices();

        System.out.println(
                "Actual Prices: " + actualPrices);

        // Create sorted copy
        ArrayList<Double> sortedPrices =
                new ArrayList<>(actualPrices);

        Collections.sort(sortedPrices);

        System.out.println(
                "Sorted Prices: " + sortedPrices);

        // Compare both lists
        Assert.assertEquals(
                actualPrices,
                sortedPrices);

        System.out.println("TC-03 Passed");
    }
}