
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.*;
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

    @Test(description = "User should be able to log in with valid credentials and add an item to the cart", priority = 1)
    public void user_should_login_successfully_with_valid_credentials() {
        ExtentTest test = extent.createTest("User should be able to log in with valid credentials and add an item to the cart");

        String username = config.getProperty("username");
        String password = config.getProperty("password");
        String backpackExpectedName = expectedContent.getProperty("backpackExpectedName");
        int expectedInventorySize = Integer.parseInt(expectedContent.getProperty("inventorySize"));
        test.info("Test data OK");

        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);
        StorePage storePage = new StorePage(driver);
        CartPage cartPage = new CartPage(driver);
        test.info("Page models OK");

        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.submitLogin();
        test.pass("Login Successful");

        storePage.verifyLogo();
        test.pass("Logo is visible");
        storePage.verifyItemQuantity(expectedInventorySize);
        test.pass("inventory has expected items");
        storePage.addItemToCart(backpackName);
        storePage.openCart();

        cartPage.verifyAddedItem(backpackExpectedName);
        test.pass("item added to cart successfully");
        cartPage.removeBackpack();
        test.info("cart reverted");
    }

    @Test(description = "User should be able to log in with valid credentials and complete the checkout", priority = 2)
    public void user_should_complete_the_checkout() {
        ExtentTest test = extent.createTest("User should be able to log in with valid credentials and complete the checkout");

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
        test.log(Status.INFO, "test data OK");

        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);
        StorePage storePage = new StorePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutFormPage checkoutFormPage = new CheckoutFormPage(driver);
        FinishCheckoutPage finishCheckoutPage = new FinishCheckoutPage(driver);
        test.log(Status.INFO, "Page models OK");

        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.submitLogin();
        test.log(Status.PASS, "Login Successful");

        storePage.addItemToCart(backpackName);
        storePage.openCart();

        cartPage.continueCheckout();
        test.info("going to checkout");

        checkoutFormPage.fillFirstNameInput(firstName);
        checkoutFormPage.fillLastNameInput(lastName);
        checkoutFormPage.fillPostalCodeInput(postalCode);
        checkoutFormPage.submitForm();
        test.info("form filled");

        finishCheckoutPage.verifyPaymentInformation(paymentInformation);
        finishCheckoutPage.verifyShippingInformation(shippingInformation);
        finishCheckoutPage.verifyPriceInformation(priceInfo, taxInfo, totalPrice);
        test.pass("Order info is as expected");
    }

    @Test(description = "User should not be able to log in with invalid credentials")
    public void user_should_not_be_able_to_log_in_with_invalid_credentials() {
        ExtentTest test = extent.createTest("User should not be able to log in with invalid credentials");


        String username = Utils.generateRandomString(8);
        String password = Utils.generateRandomString(10);
        String expectedErrorMessage = expectedContent.getProperty("errorMessage");
        test.warning("username and password are random");
        test.info("test data OK");

        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);
        test.info("page model OK");

        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.submitLogin();
        loginPage.verifyErrorMessageIsVisible();
        loginPage.verifyErrorMessage(expectedErrorMessage);
        test.pass("Error is visible and contains the expected message");
    }
}
