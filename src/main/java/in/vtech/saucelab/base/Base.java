package in.vtech.saucelab.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import in.vtech.saucelab.listeners.TestNGListener;

public class Base {
	public static WebDriver driver;
	public static WebDriverWait explicitWait;
	public static Logger logger = LogManager.getLogger(TestNGListener.class);

	public static void initialization() {
		String chromeDriver = "D:\\selenium-files\\chromedriver\\131\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriver);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		String baseUrl = "https://www.saucedemo.com/";
		driver.get(baseUrl);

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	public static void tearDown() {
		driver.quit();
	}

}
