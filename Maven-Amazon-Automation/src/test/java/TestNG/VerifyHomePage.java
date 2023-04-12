package TestNG;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Page.AmazonMiniTvPage;
import Page.HomePage;
import Page.ProductDetailsPage;
import Page.ResultPage;
import Page.SignInPage;
import Utils.Utility;
import browserSetup.Base;

public class VerifyHomePage extends Base {
	WebDriver driver;
	HomePage homePage;
	SignInPage signInPage;
	 AmazonMiniTvPage amazonMiniTvPage;

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
	public void createPOMObjects() {
		System.out.println("Before Class");
		homePage=new HomePage(driver);
		amazonMiniTvPage=new AmazonMiniTvPage(driver);
		signInPage=new SignInPage(driver);
		
		
	}
   
	@BeforeMethod
    public void goToHomePage() {
    	System.out.println("BeforeMethod");
    	driver.get("https://www.amazon.in");	
    }
    
    @Test(priority=1)
    public void verifyAmazonMiniTvPage() {
    	System.out.println("test 1");
        homePage.clickOnAmazonMiniTvButton();
        
        amazonMiniTvPage.clickOnWebSeriesButton();
        amazonMiniTvPage.clickOnCorosolButton();
        amazonMiniTvPage.clickOnFirstWebSriesLInk();
    }
    
    @Test(priority=2)
    public void verifySearchTextBox() {
    	System.out.println("test 2");
    	
    	homePage.sendInSearch();
    	homePage.clickOnSearchIcon();
    	ResultPage resultPage=new ResultPage(driver);
    	resultPage.clickOnFirstMobileDisplayed();
    	ArrayList<String> addr=new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		ProductDetailsPage productDetailsPage=new ProductDetailsPage(driver);
		productDetailsPage.clickOnAddToCartButton();
    	
    	}
    @Test (priority=3)
    public void verifySignInPage() throws IOException, InterruptedException {
    	System.out.println("test 3");
    	Thread.sleep(2000);
    	homePage=new HomePage(driver);
    	homePage.clickOnHelloSignInButton();
    	homePage.clickOnSignInButton();
        
    //	String data=Utility.getExcelData("UserPass2", 6, 0);
    	signInPage.sendInEmailTextBox(Utility.getExcelData("UserPass1", 1, 0));
    	signInPage.clickOnContinueButton();
    	Thread.sleep(2000);
    	signInPage.sendInPasswordTextBox(Utility.getExcelData("UserPass1", 1, 1));
    	signInPage.clickOnSignInButton();
    }
    @AfterMethod
	public void afterMethod(){
		System.out.println("After Method");

	}
	
	@AfterClass
	public void clearObjects() {
		System.out.println("After Class");
		homePage=null;
		amazonMiniTvPage=null;
		signInPage=null;
		
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
		driver.quit();
		driver=null;
		System.gc();
		
	}
}
