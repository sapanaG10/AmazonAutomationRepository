package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage {
	
	@FindBy (xpath="//input[@id='businessEmail-field-id']")
	private WebElement EnterEmailaddress;
	
	@FindBy (xpath="//span[text()='Get started']")
	private WebElement GetStartedButton;
	
	@FindBy (xpath="//span[text()='Let us create your free Amazon Business account']")
	private WebElement TextMessage;
	
	@FindBy (xpath="//span[text()='Learn more about Amazon Business']")
	private WebElement LearnMoreAboutAmazonLink;
	
	public AccountCreationPage(WebDriver driver) {
		   PageFactory.initElements(driver, this);
	}
	
	public void sendInEnterEmailaddress() {
		EnterEmailaddress.sendKeys("abcd@gmail.com");
	}
	
	public void clickOnGetStartedButton() {
		GetStartedButton.click();
	}
	
	public String TextMessage() {
		String text=TextMessage.getText();
	return text;
	}
	public void clickOnLearnMoreAboutAmazonLink() {
		LearnMoreAboutAmazonLink.click();
	}
}
