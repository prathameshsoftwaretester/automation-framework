package ui.pages;

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {

    WebDriver driver;

    // Constructor
    public InventoryPage(WebDriver driver) {

        this.driver = driver;
    }

    By title = By.className("title");

    By products = By.className("inventory_item");
    
    By productNames = By.className("inventory_item_name");

    By cart = By.className("shopping_cart_link");
    
    By sortDropdown = By.className("product_sort_container");

    By productPrices = By.className("inventory_item_price");
    
    By backpackAddButton =
            By.id("add-to-cart-sauce-labs-backpack");

    By bikeLightAddButton =
            By.id("add-to-cart-sauce-labs-bike-light");

    By boltShirtAddButton =
            By.id("add-to-cart-sauce-labs-bolt-t-shirt");

    public boolean isTitleDisplayed() {

        return driver.findElement(title)
                .isDisplayed();
    }

    public int getProductCount() {

        List<WebElement> productList =
                driver.findElements(products);

        return productList.size();
    }

    public boolean isCartVisible() {

        return driver.findElement(cart)
                .isDisplayed();
    }
    
    public void sortByLowToHigh() {

        Select dropdown =
                new Select(driver.findElement(sortDropdown));

        dropdown.selectByVisibleText("Price (low to high)");
    }
    
    public ArrayList<String> getProductNames() {

        List<WebElement> nameElements =
                driver.findElements(productNames);

        ArrayList<String> productNamesList =
                new ArrayList<>();

        for (WebElement name : nameElements) {

            productNamesList.add(name.getText());
        }

        return productNamesList;
    }
    
    public ArrayList<Double> getProductPrices() {

        List<WebElement> priceElements =
                driver.findElements(productPrices);

        ArrayList<Double> actualPrices =
                new ArrayList<>();

        for (WebElement price : priceElements) {

            String priceText =
                    price.getText().replace("$", "");

            actualPrices.add(
                    Double.parseDouble(priceText));
        }

        return actualPrices;
    }
    
    public void addBackpackToCart() {

        driver.findElement(backpackAddButton)
                .click();
    }

    public void addBikeLightToCart() {

        driver.findElement(bikeLightAddButton)
                .click();
    }

    public void addBoltShirtToCart() {

        driver.findElement(boltShirtAddButton)
                .click();
    }
}