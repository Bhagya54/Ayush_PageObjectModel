package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pages.BMWCarsPage;
import pages.HomePage;
import pages.HyundaiCarsPage;
import pages.MarutiCarsPage;
import pages.NewCarsPage;
import pages.TataCarsPage;
import pages.ToyotaCarsPage;
import utility.DataUtils;

public class FindCarModelAndPrices extends BaseTest {

	@Test(dataProviderClass = DataUtils.class,dataProvider = "dp")
	public void findCarModelsAndPrices(String browserName,String runMode,String carName) {
		if(runMode.equals("n")) {
			throw new SkipException("skipping the testcase as the runmode is n");
		}
		
		setUp(browserName);
		HomePage homePage = new HomePage(driver);
		NewCarsPage newCarsPage=homePage.findNewCars();
		
		if(carName.equalsIgnoreCase("hyundai")) {
			HyundaiCarsPage hyundaiCarsPage = newCarsPage.clickOnHyundai();
			//Assert.assertEquals(hyundaiCarsPage.getTitle(),expectedCarTitle);
		}
		
		else if(carName.equalsIgnoreCase("bmw")) {
			BMWCarsPage bmwCarsPage = newCarsPage.clickOnBMW();
			//Assert.assertEquals(bmwCarsPage.getTitle(),expectedCarTitle);
		}
		
		else if(carName.equalsIgnoreCase("maruti")) {
			MarutiCarsPage marutiCarsPage = newCarsPage.clickOnMaruti();
			//Assert.assertEquals(marutiCarsPage.getTitle(),expectedCarTitle);
		}
		
		else if(carName.equalsIgnoreCase("tata")) {
			TataCarsPage tataCarsPage = newCarsPage.clickOnTata();
			//Assert.assertEquals(tataCarsPage.getTitle(),expectedCarTitle);
		}
		
		else if(carName.equalsIgnoreCase("toyota")) {
			ToyotaCarsPage toyotaCarsPage = newCarsPage.clickOnToyota();
			//Assert.assertEquals(toyotaCarsPage.getTitle(),expectedCarTitle);
		}
		
		//Assert.assertEquals(BasePage.carBase.getTitle(),expectedCarTitle);
		
		BasePage.carBase.getCarModelAndPrices();
		
		
	}
	
}
