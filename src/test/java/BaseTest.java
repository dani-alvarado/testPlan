import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
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
    protected ExtentReports extent = new ExtentReports();
    protected ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");



    @BeforeClass
    public void setUp() {
        extent.attachReporter(spark);
        driver = new ChromeDriver(); // Sets the driver
        basePage = new BasePage(driver); // Sets the base page
        config = LoadProperties.loadProperties("src/main/resources/config.properties");
        expectedContent = LoadProperties.loadProperties("src/main/resources/expected_contents.properties");
        dynamicLocators = LoadProperties.loadProperties("src/main/resources/dynamic_locators.properties");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        extent.flush();
    }


    public WebDriver getDriver() {
        return driver;
    }
}
