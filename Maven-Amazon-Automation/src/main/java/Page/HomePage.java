package Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	  //variable declaration
	    @FindBy (xpath="//input[@id='twotabsearchtextbox']")
        private WebElement SearchTextBox;
	
	    @FindBy (xpath="//input[@id='nav-search-submit-button']")
	    private WebElement SearchIcon;
	    
	    @FindBy (xpath="//a[text()='Amazon miniTV']")
	    private WebElement AmazonMiniTvButton;
	    
	    @FindBy (xpath="//span[text()='Hello, sign in']")
		private WebElement HelloSignInButton;
	    
	    @FindBy (xpath="(//span[text()='Sign in'])[1]")
		private WebElement SignInButton;
		
	    @FindBy (xpath="//a[@href='/business?ref=footer_aingw']")
		private WebElement AmazonBusinessButton;
		
	   private WebDriver driver;
    
	   //variable initialization
		public HomePage(WebDriver driver) {
		   PageFactory.initElements(driver, this);
		   this.driver=driver;
		}
				
      //variable use
		public void sendInSearch() {
		     SearchTextBox.sendKeys("Mobile phones");
		}
		public void clickOnSearchIcon() {
			SearchIcon.click();
		}
		public void clickOnAmazonMiniTvButton() {
			AmazonMiniTvButton.click();
		}
		public void clickOnHelloSignInButton() {
			Actions act=new Actions(driver);
			act.moveToElement(HelloSignInButton).build().perform();
		}
		public void clickOnSignInButton() {
			Actions act=new Actions(driver);
			act.moveToElement(SignInButton).click().build().perform();
		}
		public void clickOnAmazonBusinessButton() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,7000)");
			
			AmazonBusinessButton.click();
		}
		public void clearSearchTextBox() {
			SearchTextBox.clear();
		}
}
