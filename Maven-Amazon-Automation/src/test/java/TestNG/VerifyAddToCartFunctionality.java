package TestNG;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Page.HomePage;
import Page.ProductDetailsPage;
import Page.ResultPage;
import Utils.Utility;
import browserSetup.Base;

public class VerifyAddToCartFunctionality extends Base {
	WebDriver driver;
	HomePage homePage;
	ProductDetailsPage productDetailsPage;
	String testID;
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName) {
		System.out.println("Before Test");
		
		if(browserName.equals("Chrome"))
		{
			driver=openChromeBrowser();
		}
		
		if(browserName.equals("Edge"))
		{
			driver=openEdgeBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
	}
	
	@BeforeClass
	public void createPOMObject() {
		homePage=new HomePage(driver);
		productDetailsPage=new ProductDetailsPage(driver);
	}
	
	@BeforeMethod
	public void goToHomePageItem() {
		driver.get("https://www.amazon.in/");
		
        homePage.sendInSearch();
    	homePage.clickOnSearchIcon();
    	ResultPage resultPage=new ResultPage(driver);
    	resultPage.clickOnFirstMobileDisplayed();
    	ArrayList<String> addr=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		productDetailsPage.clickOnAddToCartButton();
			
	}
	@Test(priority=1)
	public void verifyTextOnCartPage() throws InterruptedException {
	    testID="T101";
		Thread.sleep(3000);
        String actualMsg=productDetailsPage.TextMessageAddedtocart();
		String expectedMsg="Added to Cart";
		Assert.assertEquals(actualMsg, expectedMsg);   
		
//		if(actualMsg.equals(expectedMsg)) {
//			System.out.println("Passed");
//		}
//		else {
//			System.out.println("FAILED");
//		}
	}
	@Test(priority=3)
	public void verifyCartButton() throws InterruptedException {
		testID="T102";
        Thread.sleep(3000);
		productDetailsPage.clickOnCartButton();
		
	}
	@Test(priority=2)
	public void verifyProceedToCheckOutButton() throws InterruptedException {
		testID="T103";
        Thread.sleep(3000);
		productDetailsPage.clickOnProceedToCheckoutButton();
		
	}
	@AfterMethod
	public void logOut(ITestResult result){
		
		if(ITestResult.FAILURE==result.getStatus()) {
			Utility.captureScreen(driver, testID);
		}
		driver.close();
		ArrayList<String> addr=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(0));
		homePage.clearSearchTextBox();
	}
	
	@AfterClass
	public void clearObjects() {
		System.out.println("After Class");
		homePage=null;
		productDetailsPage=null;
		
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
		driver.quit();
		driver=null;
		System.gc();             // Garbage collector
	}

}


