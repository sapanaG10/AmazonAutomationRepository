package TestNG;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Page.AccountCreationPage;
import Page.AmazonBusinessPage;
import Page.HomePage;
import Page.ProductDetailsPage;
import browserSetup.Base;


public class VerifyAmazonBusinessPage extends Base {
	WebDriver driver;
	HomePage homePage;
	ProductDetailsPage productDetailsPage;
	AccountCreationPage accountCreationPage;
	AmazonBusinessPage amazonBusinessPage;
	
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
	
	}
	@BeforeClass
	public void createPOMObject() {
		homePage=new HomePage(driver);
		productDetailsPage=new ProductDetailsPage(driver);
		amazonBusinessPage=new AmazonBusinessPage(driver);
		accountCreationPage=new AccountCreationPage(driver);
	}
	
	
	@BeforeMethod
	public void goToAmazonBusinessPage() {
		driver.get("https://www.amazon.in/");
		
		homePage.clickOnAmazonBusinessButton();
		amazonBusinessPage.clickOnProvideYourEmailHere();
		
   }
	@Test(priority=1)
	public void verifyAmazonBusinessPage() throws InterruptedException {
		System.out.println("Test 1");
		
		String actualText=accountCreationPage.TextMessage();
		String expectedText="Let us create your free Amazon Business account";
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actualText, expectedText);
	    soft.assertAll();
//		if(actualText.equals(expectedText)) {
//			System.out.println("PASSED");
//		}
//		else {
//			System.out.println("FAILED");
//		}
		accountCreationPage.sendInEnterEmailaddress();
		accountCreationPage.clickOnGetStartedButton();
   
	}
	@Test(priority=2)
	public void verifyLearnMoreAboutAmazonLink() {
		System.out.println("Test 2");
		accountCreationPage.clickOnLearnMoreAboutAmazonLink();
	    String actualUrl=driver.getCurrentUrl();
		String expectedUrl="https://business.amazon.in/?ref_=ab_reg_enteremail";
		Assert.assertEquals(actualUrl, expectedUrl);    //hard assert
		
//		if(actualUrl.equals(expectedUrl)) {
//			System.out.println("PASSED");
//		}
//		else {
//			System.out.println("FAILED");
//		}
		
	}
	@AfterMethod
	public void afterMethod(){
		System.out.println("After Method");
	
	}
	
	@AfterClass
	public void clearObjects() {
		System.out.println("After Class");
		homePage=null;
		productDetailsPage=null;
		amazonBusinessPage=null;
		accountCreationPage=null;
		
	}
	@AfterTest
	public void afterTest() {
		
		System.out.println("After Test");
		driver.quit();
		driver=null;
		System.gc();
		
	}

}
