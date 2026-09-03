package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class NewCarsPage extends BasePage{

	

	public NewCarsPage(WebDriver driver) {

		super(driver);
	}
	
	
	public TataCarsPage clickOnTata() {
		WebElement tata=driver.findElement(By.xpath("//div[text()='Tata']"));
		tata.click();
		return new TataCarsPage(driver);
	}
	
	public MarutiCarsPage clickOnMaruti() {
		WebElement maruti=driver.findElement(By.xpath("//div[text()='Maruti Suzuki']"));
		maruti.click();
		return new MarutiCarsPage(driver);
	}
	
	
	public HyundaiCarsPage clickOnHyundai() {
		WebElement hyundai=driver.findElement(By.xpath("//div[text()='Hyundai']"));
		hyundai.click();
		return new HyundaiCarsPage(driver);
	}
	
	public ToyotaCarsPage clickOnToyota() {
		WebElement toyota=driver.findElement(By.xpath("//div[text()='Toyota']"));
		toyota.click();
		return new ToyotaCarsPage(driver);
	}
	public BMWCarsPage clickOnBMW() {
		WebElement bmw=driver.findElement(By.xpath("//div[text()='BMW']"));
		bmw.click();
		return new BMWCarsPage(driver);
	}
}
