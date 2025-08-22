package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;

public class CheckoutTest extends BaseTest {
	@Test
	public void testCheckout() {
		LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = productPage.addFirstProductToCart();
        cartPage.goToCart();

        CheckoutPage checkoutPage = cartPage.proceedToCheckout();
        checkoutPage.fillDetails("Sunita", "Veer", "12345");
        checkoutPage.continueCheckout();
        checkoutPage.finishCheckout();

        Assert.assertEquals(checkoutPage.getSuccessMessage(), "THANK YOU FOR YOUR ORDER");
	}


}
