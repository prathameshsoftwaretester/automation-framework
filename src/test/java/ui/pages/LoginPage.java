package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    // Locators
    By username = By.id("user-name");

    By password = By.id("password");

    By loginButton = By.id("login-button");
    
    By errorMessage = By.cssSelector("h3[data-test='error']");

    // Actions
    public void enterUsername(String user) {

        driver.findElement(username)
                .sendKeys(user);
    }

    public void enterPassword(String pass) {

        driver.findElement(password)
                .sendKeys(pass);
    }

    public void clickLogin() {

        driver.findElement(loginButton)
                .click();
    }

    public void login(String user, String pass) {

        enterUsername(user);

        enterPassword(pass);

        clickLogin();
    }
    
    public String getErrorMessage() {

        return driver.findElement(errorMessage)
                .getText();
    }
}