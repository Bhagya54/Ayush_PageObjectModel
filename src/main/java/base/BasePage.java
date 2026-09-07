package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;

public class BasePage {
	public WebDriver driver;
	public static CarBase carBase;

	public BasePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		carBase=new CarBase(driver);
	}
}
