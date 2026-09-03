package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.BasePage;

public class HomePage extends BasePage{
	
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	
	public void searchCars() {
		WebElement searchTxtBox=driver.findElement(By.xpath("(//input[@aria-label='Input field'])[1]"));
		searchTxtBox.sendKeys("BMW");
	}
	
	public NewCarsPage findNewCars() {
		WebElement newCars=driver.findElement(By.xpath("//div[normalize-space()='NEW CARS']"));
		Actions act=new Actions(driver);
		act.moveToElement(newCars).perform();
		
		WebElement findNewCars=driver.findElement(By.xpath("//div[text()='Find New Cars']"));
		findNewCars.click();
		return new NewCarsPage(driver);
	}
}
