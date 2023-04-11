package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
	//variable declaration
			@FindBy (xpath="(//div[@data-index='2']//div[2])[1]")
		    private WebElement FirstMobileDisplayed;
			

			//	variable initialization
			public ResultPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
			//variable use
			public void clickOnFirstMobileDisplayed() {
				FirstMobileDisplayed.click();
			}

}
