package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinishCheckoutPage extends BasePage {
    private final By paymentInformationLocator = By.xpath("//*[contains(text(), \"SauceCard\")]");
    private final By shippingInformationLocator = By.xpath("//*[contains(text(), \"Pony\")]");
    private final By subtotalLocator = By.className("summary_subtotal_label");
    private final By taxLocator = By.className("summary_tax_label");
    private final By totalLocator = By.className("summary_total_label");


    public FinishCheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void verifyPaymentInformation(String paymentInfo){
        WebElement paymentInformation = driver.findElement(paymentInformationLocator);
        waitForElementToBeVisible(paymentInformation);
        assert paymentInformation.getText().equals(paymentInfo);
    }

    public void verifyShippingInformation(String shippingInfo){
        WebElement shippingInformation = driver.findElement(shippingInformationLocator);
        waitForElementToBeVisible(shippingInformation);
        assert shippingInformation.getText().equals(shippingInfo);
    }

    public void verifyPriceInformation(String subTotal, String tax, String total){
        WebElement subtotalElement = driver.findElement(subtotalLocator);
        WebElement taxElement = driver.findElement(taxLocator);
        WebElement totalElement = driver.findElement(totalLocator);
        waitForElementToBeVisible(subtotalElement);
        waitForElementToBeVisible(taxElement);
        waitForElementToBeVisible(totalElement);
        assert subtotalElement.getText().contains(subTotal);
        assert taxElement.getText().contains(tax);
        assert totalElement.getText().contains(total);
    }

}
