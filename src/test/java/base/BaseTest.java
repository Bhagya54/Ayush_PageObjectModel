package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import utility.ExcelReader;

public class BaseTest {
	/*
	 * WebDriver TestNG Excel Log4j Properties FileInputStream Screenshot Extent
	 * Report Keyword(type/click) Implicit Wait Explicit Wait
	 * 
	 * Sequential Approach 1. open the browser 2. tc1 tc2 tc3 3. Close browser
	 *
	 * 
	 * End to end 
	 * open the browser 
	 * tc1 
	 * Close browser 
	 * 
	 * open the browser 
	 * tc2 
	 * Close browser
	 */

	public static WebDriver driver;
	public WebDriverWait wait;
	public ExcelReader excel = new ExcelReader("./src/test/resources/testData/excelTestData.xlsx");
	public FileInputStream fis;
	public Properties config = new Properties();
	public Properties or = new Properties();
	public Logger log = Logger.getLogger(BaseTest.class);
	

	
	public void setUp(String browser) {
		try {
			fis = new FileInputStream("./src/test/resources/properties/log4j.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PropertyConfigurator.configure(fis);

		try {
			fis = new FileInputStream("./src/test/resources/properties/config.properties");
			config.load(fis);
			log.info("Config properties file has been loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			log.info("Chrome browser has been launched");
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-notifications");
			driver = new FirefoxDriver(options);
			log.info("Firefox browser has been launched");
		}

		else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-notifications");
			driver = new EdgeDriver(options);
			log.info("Edge browser has been launched");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicitWait"))));
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicitWait"))));
		driver.get(config.getProperty("testsiteurl"));
		log.info("Navigated to a site: " + config.getProperty("testsiteurl"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
