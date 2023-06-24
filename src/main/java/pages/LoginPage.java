package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final By usernameInputLocator = By.id("user-name");
    private final By passwordInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");
    private final By errorMessageLocator = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeUsername(String username) {
        WebElement usernameInput = driver.findElement(usernameInputLocator);
        waitForElementToBeVisible(usernameInput);
        usernameInput.sendKeys(username);
    }

    public void typePassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        waitForElementToBeVisible(passwordInput);
        passwordInput.sendKeys(password);
    }

    public void submitLogin() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        waitForElementToBeClickable(loginButton);
        loginButton.click();
    }

    public void verifyUrl(String expectedUrl){
        String actualUrl = driver.getCurrentUrl();
        assert actualUrl.equals(expectedUrl) : "Urls do not match";
    }

    public void verifyErrorMessageIsVisible(){
        WebElement errorMessage = driver.findElement(errorMessageLocator);
        waitForElementToBeVisible(errorMessage);
    }
    public void verifyErrorMessage(String expectedErrorMessage){
        WebElement errorMessage = driver.findElement(errorMessageLocator);
        waitForElementToBeVisible(errorMessage);
        assert errorMessage.getText().equals(expectedErrorMessage);
    }

}
