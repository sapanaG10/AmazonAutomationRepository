package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonBusinessPage {
	
	@FindBy (xpath="(//img[@alt='Banner'])[3]")
	private WebElement ProvideYourEmail;
	
	public AmazonBusinessPage(WebDriver driver) {
		   PageFactory.initElements(driver, this);
	}
	
	public void clickOnProvideYourEmailHere() {
		ProvideYourEmail.click();
	}
	
	

}
