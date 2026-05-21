package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ui.base.BaseTest;
import ui.pages.LoginPage;

public class LockedOutUserTest extends BaseTest {

    @Test
    public void lockedUserValidationTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        // Login with locked user
        loginPage.login(
                "locked_out_user",
                "secret_sauce");

        // Verify user still on login page
        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("saucedemo.com"));

        // Capture error message
        String actualError =
                loginPage.getErrorMessage();

        System.out.println(
                "Error Message: " + actualError);

        // Verify error contains locked out
        Assert.assertTrue(
                actualError.contains("locked out"));

        System.out.println("TC-02 Passed");
    }
}