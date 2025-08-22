package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    private By cartBadge = By.className("shopping_cart_badge");
    private By cartLink = By.className("shopping_cart_link");
    private By checkoutBtn = By.xpath("//a[text()='CHECKOUT']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductAdded() {
        return driver.findElement(cartBadge).isDisplayed();
    }

    public void goToCart() {
        driver.findElement(cartLink).click();
    }

    public CheckoutPage proceedToCheckout() {
        driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
    }
}
