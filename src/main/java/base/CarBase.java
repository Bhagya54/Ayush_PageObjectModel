package base;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarBase {

	WebDriver driver;
	
	public CarBase(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h1[@data-skin='title']")
	WebElement carTitle;
	public String getTitle() {
		String title=carTitle.getText();
		System.out.println("Title: " + title);
		return title;
	}
	
	@FindBy(xpath="//h3")
	List<WebElement> carModels;
	
	@FindBy(xpath="//div/div[3]/div/span/span[1]")
	List<WebElement> carPrices;
	
	
	public void getCarModelAndPrices() {
		for(int i=0;i<carPrices.size();i++) {
			System.out.println("Car Model: " + carModels.get(i).getText());
			System.out.println("Car Price: " + carPrices.get(i).getText());
		}
	}
}
