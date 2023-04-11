package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Page.AccountCreationPage;
import Page.AmazonBusinessPage;
import Page.HomePage;

public class TestClass3 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\testing\\automation\\chromedriver_win32\\chromedriver.exe");
		 ChromeOptions ops=new ChromeOptions();
		 ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(ops);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in");
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnAmazonBusinessButton();
		
		AmazonBusinessPage amazonBusinessPage=new AmazonBusinessPage(driver);
		amazonBusinessPage.clickOnProvideYourEmailHere();
		
		AccountCreationPage accountCreationPage=new AccountCreationPage(driver);
		String text=accountCreationPage.TextMessage();
		System.out.println(text);
		
		accountCreationPage.sendInEnterEmailaddress();
		accountCreationPage.clickOnGetStartedButton();

}
}