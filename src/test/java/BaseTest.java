import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.BasePage;
import utils.LoadProperties;

import java.util.Properties;

// This class sets the driver and base page for the tests that inherit its properties
public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected Properties config;
    protected Properties expectedContent;
    protected Properties dynamicLocators;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver(); // Sets the driver
        basePage = new BasePage(driver); // Sets the base page
        config = LoadProperties.loadProperties("src/main/resources/config.properties");
        expectedContent = LoadProperties.loadProperties("src/main/resources/expected_contents.properties");
        dynamicLocators = LoadProperties.loadProperties("src/main/resources/dynamic_locators.properties");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
