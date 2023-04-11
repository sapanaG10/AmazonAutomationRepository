package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	@FindBy (xpath="//input[@name='email']")
	private WebElement EmailOrMobileNoTextBox;
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement ContinueButton;
	
	@FindBy (xpath="//input[@type='password']")
	private WebElement PasswordTextBox;	
	
	@FindBy (xpath="//input[@id='signInSubmit']")
	private WebElement SignInButton;	
	
	public SignInPage(WebDriver driver) {
		   PageFactory.initElements(driver, this);
	}
	
	public void sendInEmailTextBox(String user) {
		EmailOrMobileNoTextBox.sendKeys(user);
	}
	
	public void clickOnContinueButton() {
		ContinueButton.click();
	}
	public void sendInPasswordTextBox(String pass) {
		PasswordTextBox.sendKeys(pass);
	}
	public void clickOnSignInButton() {
		SignInButton.click();
	}

}
