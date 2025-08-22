package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "credentials")
    public Object[][] credentials() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user","secret_sauce"},
                {"problem_user","secret_sauce"},
                {"performance_glitch_user","secret_sauce"}
        };
    }

    @Test(dataProvider = "credentials")
    public void testLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        //Homepage load verification
        String expectedUrl = "https://www.saucedemo.com/v1/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}
