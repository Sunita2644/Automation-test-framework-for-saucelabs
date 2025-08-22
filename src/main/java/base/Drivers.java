package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drivers {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if (driver == null) {
            WebDriverManager.chromedriver().setup(); // This auto-manages the driver binary
            driver = new ChromeDriver();
		}
		return driver;
	}
	
	public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
	
}
