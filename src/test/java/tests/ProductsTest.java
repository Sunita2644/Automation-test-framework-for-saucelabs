package tests;


import org.testng.annotations.Test;
import pages.ProductPage;

public class ProductsTest extends BaseTest {
	@Test
	public void testProductFilterLowToHigh() {
		ProductPage productpage = new ProductPage(driver);
		productpage.filterLowToHigh();
		productpage.printAllProducts();
	}

}
