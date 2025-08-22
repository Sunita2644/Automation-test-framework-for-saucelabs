package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.Drivers;
import utils.ExtentTestListener;
import utils.configReader;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
    public void setUp() {
        driver = Drivers.getDriver();
        ExtentTestListener.driver.set(driver);
        driver.manage().window().maximize();
        String baseUrl = configReader.get("url");
        driver.get(baseUrl);
	}
	
	@AfterMethod
    public void tearDown() {
        Drivers.quitDriver();
    }
}
