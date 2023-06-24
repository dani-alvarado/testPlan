package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private final By cartItemNameLocator = By.className("inventory_item_name");
    private final By checkoutButtonLocator = By.id("checkout");
    private final By removeButtonLocator = By.id("remove-sauce-labs-backpack");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void verifyAddedItem(String itemName) {
        WebElement cartItemName = driver.findElement(cartItemNameLocator);
        waitForElementToBeVisible(cartItemName);
        assert cartItemName.getText().equals(itemName);
    }

    public void continueCheckout() {
        WebElement checkoutButton = driver.findElement(checkoutButtonLocator);
        waitForElementToBeClickable(checkoutButton);
        checkoutButton.click();
    }

    public void removeBackpack(){
        WebElement removeBackpackButton = driver.findElement(removeButtonLocator);
        waitForElementToBeClickable(removeBackpackButton);
        removeBackpackButton.click();
    }

}
