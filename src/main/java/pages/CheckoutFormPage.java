package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutFormPage extends BasePage {

    private final By firstNameInputLocator = By.id("first-name");
    private final By lastNameInputLocator = By.id("last-name");
    private final By postalCodeInputLocator = By.id("postal-code");
    private final By submitLocator = By.id("continue");
    public CheckoutFormPage(WebDriver driver) {
        super(driver);
    }

    public void fillFirstNameInput(String firstName){
        WebElement firstNameInput = driver.findElement(firstNameInputLocator);
        waitForElementToBeVisible(firstNameInput);
        firstNameInput.sendKeys(firstName);
    }
    public void fillLastNameInput(String lastName){
        WebElement lastNameInput = driver.findElement(lastNameInputLocator);
        waitForElementToBeVisible(lastNameInput);
        lastNameInput.sendKeys(lastName);
    }
    public void fillPostalCodeInput(String postalCode){
        WebElement postalCodeInput = driver.findElement(postalCodeInputLocator);
        waitForElementToBeVisible(postalCodeInput);
        postalCodeInput.sendKeys(postalCode);
    }

    public void submitForm(){
        WebElement submitButton = driver.findElement(submitLocator);
        waitForElementToBeClickable(submitButton);
        submitButton.click();
    }
}
