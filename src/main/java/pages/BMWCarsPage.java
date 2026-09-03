package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class BMWCarsPage extends BasePage {
	
	public BMWCarsPage(WebDriver driver) {
		super(driver);	
	}

	public void getTitle() {
		String title=driver.findElement(By.xpath("//h1[@data-skin='title']")).getText();
		System.out.println("Title: " + title);
	}
}
