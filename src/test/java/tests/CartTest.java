package tests;


import org.testng.annotations.Test;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;

import org.testng.Assert;

public class CartTest extends BaseTest {
	@Test
	public void testAddToCart() {
		LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = productPage.addFirstProductToCart();
        Assert.assertTrue(cartPage.isProductAdded(), "Product was not added to cart!");
	}

}
