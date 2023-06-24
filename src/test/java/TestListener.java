import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
public class TestListener extends TestListenerAdapter implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        if (driver instanceof TakesScreenshot) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = Paths.get("screenshots", result.getName() + ".png").toString();

            try {
                FileHandler.copy(screenshotFile, new File(screenshotPath));
                Reporter.log("Screenshot saved at " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
