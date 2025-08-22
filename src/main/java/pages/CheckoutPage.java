package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    private By firstName = By.xpath("//input[@id='first-name']");
    private By lastName = By.xpath("//input[@id='last-name']");
    private By postalCode = By.id("postal-code");
    private By continueBtn = By.xpath("//input[@value='CONTINUE']");
    private By finishBtn = By.xpath("//a[@href='./checkout-complete.html']");
    private By successMsg = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillDetails(String fName, String lName, String zip) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(postalCode).sendKeys(zip);
    }

    public void continueCheckout() {
        driver.findElement(continueBtn).click();
    }

    public void finishCheckout() {
        driver.findElement(finishBtn).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }
}
