package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	
	//variable declaration
		@FindBy (xpath="//input[@id='add-to-cart-button']")
	    private WebElement AddToCartButton;
		
		@FindBy (xpath="//span[@class=\"a-size-medium-plus a-color-base sw-atc-text a-text-bold\"]")
		private WebElement TextMessage;
		
		@FindBy (xpath="//span[text()=' Cart ']")
	    private WebElement CartButton;

		@FindBy (xpath="//span[@id='attach-sidesheet-checkout-button-announce']")
	    private WebElement ProceedToCheckoutButton;
		
		
		private WebDriver driver;
		private Actions act;
		//	variable initialization
		public ProductDetailsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver=driver;
		}
		
		//variable use
		public void clickOnAddToCartButton() {
			AddToCartButton.click();
		}
		
		public String TextMessageAddedtocart() {
			String text=TextMessage.getText();
			return text;
		}
		public void clickOnProceedToCheckoutButton() {
			act=new Actions(driver);
			act.moveToElement(ProceedToCheckoutButton).click().build().perform();
		}

		public void clickOnCartButton() {
			act=new Actions(driver);
			act.moveToElement(CartButton).click().build().perform();
		}
}

