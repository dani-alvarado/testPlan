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

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver(); // Sets the driver
        basePage = new BasePage(driver); // Sets the base page
        config = LoadProperties.loadProperties("config.properties");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
