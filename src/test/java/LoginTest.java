import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;

public class LoginTest extends BaseTest{

    private String baseUrl;

    @BeforeClass
    public void set() {
        baseUrl = config.getProperty("baseUrl");
    }
    @Test(description = "User should be able to log in with valid credentials")
    public void user_should_login_successfully_with_valid_credentials() {
        String username = config.getProperty("username");
        String password = config.getProperty("password");

        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.submitLogin();
        //todo: add the assertion from the store page
    }

    @Test(description = "User should not be able to log in with invalid credentials")
    public void user_should_not_be_able_to_log_in_with_invalid_credentials() {
        String username = Utils.generateRandomString(8);
        String password = Utils.generateRandomString(10);
        String expectedErrorMessage = expectedContent.getProperty("errorMessage");

        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.submitLogin();
        loginPage.verifyErrorMessageIsVisible();
        loginPage.verifyErrorMessage(expectedErrorMessage);
    }
}
