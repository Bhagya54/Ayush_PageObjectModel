package rough;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.HomePage;
import pages.HyundaiCarsPage;
import pages.NewCarsPage;

public class FindNewCarsTest {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriver driver=new ChromeDriver(options);
//		Options opt=driver.manage();
//		Window win=opt.window();
//		win.maximize();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.carwale.com");
		
//		HomePage homePage = new HomePage(driver);
//		homePage.findNewCars();
//		
//		NewCarsPage newCarsPage = new NewCarsPage(driver);
//		newCarsPage.clickOnBMW();
//		
//		BMWCarsPage bmw=new BMWCarsPage(driver);
//		bmw.getTitle();
		
		
		HomePage homePage = new HomePage(driver);
		NewCarsPage newCarsPage=homePage.findNewCars();
		HyundaiCarsPage hyundaiCarsPage = newCarsPage.clickOnHyundai();
		hyundaiCarsPage.getTitle();

		
		//new HomePage(driver).findNewCars().clickOnHyundai().getTitle();
	}

}
