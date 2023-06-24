package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StorePage extends BasePage {

    private final By logoLocator = By.className("app_logo");
    private final By cartButtonLocator = By.className("shopping_cart_link");
    private final By inventoryListLocator = By.className("inventory_list");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void verifyUrl(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        assert actualUrl.equals(expectedUrl) : "Urls do not match";
    }

    public void addItemToCart(String addToCartName) {
        By addToCartLocator = By.id(addToCartName);
        WebElement addToCartButton = driver.findElement(addToCartLocator);
        waitForElementToBeVisible(addToCartButton);
        waitForElementToBeClickable(addToCartButton);
        addToCartButton.click();
    }

    public void openCart() {
        WebElement cartButton = driver.findElement(cartButtonLocator);
        waitForElementToBeClickable(cartButton);
        cartButton.click();
    }

    public void verifyLogo() {
        WebElement logo = driver.findElement(logoLocator);
        waitForElementToBeVisible(logo);
    }

    public void verifyItemQuantity(int expectedAmount) {
        WebElement inventoryList = driver.findElement(inventoryListLocator);
        waitForElementToBeVisible(inventoryList);
        List<WebElement> inventoryItems = inventoryList.findElements(By.className("inventory_item"));
        assert inventoryItems.size() == expectedAmount : "The inventory size is not as expected (expected: " + expectedAmount + "Actual: " + inventoryItems.size() + ")";
    }
}
