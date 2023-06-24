package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final WebElement usernameInput = driver.findElement(By.id("user-name"));
    private final WebElement passwordInput = driver.findElement(By.id("password"));
    private final WebElement loginButton = driver.findElement(By.id("login-button"));
    private final WebElement errorMessage = driver.findElement(By.cssSelector("[data-test='error']"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeUsername(String username) {
        waitForElementToBeVisible(usernameInput);
        usernameInput.sendKeys(username);
    }

    public void typePassword(String password) {
        waitForElementToBeVisible(passwordInput);
        passwordInput.sendKeys(password);
    }

    public void submitLogin() {
        waitForElementToBeClickable(loginButton);
        loginButton.click();
    }


}
