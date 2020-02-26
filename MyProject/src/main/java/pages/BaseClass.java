package pages;

import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import utility.Constant;

public class BaseClass {

	private static WebDriver driver;

	public static WebDriver setup(String browser) {

		WebDriver driver = null;

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(Constant.chromeDriverName,Constant.chromePath);
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty(Constant.firefoxDriverName,Constant.firefoxPath);
			driver = new FirefoxDriver();
		}

		driver.get(Constant.URL);

		return driver;
	}

	public static void tearDown() {
		driver.quit();
	}
}
