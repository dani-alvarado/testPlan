import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.Utils;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    private String baseUrl;
    private String backpackName;

    @BeforeClass
    public void set() {
        baseUrl = config.getProperty("baseUrl");
        backpackName = dynamicLocators.getProperty("backpackLocator");
    }

    @Test(description = "User should be able to log in with valid credentials and add an item to the cart",priority = 1)
    public void user_should_login_successfully_with_valid_credentials() throws InterruptedException {
        String username = config.getProperty("username");
        String password = config.getProperty("password");
        String backpackExpectedName = expectedContent.getProperty("backpackExpectedName");
        int expectedInventorySize = Integer.parseInt(expectedContent.getProperty("inventorySize"));

        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);
        StorePage storePage = new StorePage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.submitLogin();

        storePage.verifyLogo();
        storePage.verifyItemQuantity(expectedInventorySize);
        storePage.addItemToCart(backpackName);
        storePage.openCart();

        cartPage.verifyAddedItem(backpackExpectedName);
        cartPage.removeBackpack();
    }

    @Test(description = "User should be able to log in with valid credentials and complete the checkout",priority = 2)
    public void user_should_complete_the_checkout() {
        String username = config.getProperty("username");
        String password = config.getProperty("password");
        String firstName = config.getProperty("firstName");
        String lastName = config.getProperty("lastName");
        String postalCode = config.getProperty("postalCode");
        String paymentInformation = expectedContent.getProperty("paymentInfo");
        String shippingInformation = expectedContent.getProperty("shippingInfo");
        String priceInfo = expectedContent.getProperty("price");
        String taxInfo = Utils.calculateTax(Double.parseDouble(priceInfo));
        String totalPrice = Utils.calculateTotalPrice(Double.parseDouble(priceInfo));

        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);
        StorePage storePage = new StorePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutFormPage checkoutFormPage = new CheckoutFormPage(driver);
        FinishCheckoutPage finishCheckoutPage = new FinishCheckoutPage(driver);

        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.submitLogin();

        storePage.addItemToCart(backpackName);
        storePage.openCart();

        cartPage.continueCheckout();

        checkoutFormPage.fillFirstNameInput(firstName);
        checkoutFormPage.fillLastNameInput(lastName);
        checkoutFormPage.fillPostalCodeInput(postalCode);
        checkoutFormPage.submitForm();

        finishCheckoutPage.verifyPaymentInformation(paymentInformation);
        finishCheckoutPage.verifyShippingInformation(shippingInformation);
        finishCheckoutPage.verifyPriceInformation(priceInfo,taxInfo,totalPrice);
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
