package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage {
    WebDriver driver;

    private By sortDropdown = By.className("product_sort_container");
    private By productNames = By.className("inventory_item_name");
    private By firstAddToCartBtn = By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void filterLowToHigh() {
    	LoginPage loginpage = new LoginPage(driver);
    	loginpage.login("standard_user","secret_sauce");
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByValue("lohi");
    }

    public void printAllProducts() {
        List<WebElement> products = driver.findElements(productNames);
        for (WebElement p : products) {
            System.out.println(p.getText());
        }
    }

    public CartPage addFirstProductToCart() {
        driver.findElement(firstAddToCartBtn).click();
        return new CartPage(driver);
    }
}
