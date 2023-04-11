package Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Page.HomePage;
import Page.ProductDetailsPage;
import Page.ResultPage;

public class TestClass2 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\testing\\automation\\chromedriver_win32\\chromedriver.exe");
		 ChromeOptions ops=new ChromeOptions();
		 ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(ops);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in");
		
		HomePage homePage=new HomePage(driver);
		
		homePage.sendInSearch();
		homePage.clickOnSearchIcon();
		ResultPage resultPage=new ResultPage(driver);
		resultPage.clickOnFirstMobileDisplayed();
		
		ArrayList<String> addr=new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		ProductDetailsPage productDetailsPage=new ProductDetailsPage(driver);
		productDetailsPage.clickOnAddToCartButton();
		Thread.sleep(5000);
		
		String text=productDetailsPage.TextMessageAddedtocart();
		System.out.println(text);
		Thread.sleep(5000);
		//productDetailsPage.clickOnCartButton();
		productDetailsPage.clickOnProceedToCheckoutButton();

}
}