package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonMiniTvPage {

	  //variable declaration
    @FindBy (xpath="//h1[text()='Web Series']")
    private WebElement WebSeriesButton;

    @FindBy (xpath="(//img[@decoding='async'])[2]")
    private WebElement CorosolButton;
    
    @FindBy (xpath="((//div[@style='position: relative;'])[2]//div)[3]")
    private WebElement FirstWebSriesLInk;
    
    WebDriver driver;
 //variable initialization
	public AmazonMiniTvPage(WebDriver driver) {
	   PageFactory.initElements(driver, this);
	   this.driver=driver;
	}
			
  //variable use
	public void clickOnWebSeriesButton() {
		WebSeriesButton.click();
	}
	public void clickOnCorosolButton() {
		  Actions act=new Actions(driver);
		  act.moveToElement(CorosolButton).click().build().perform();
		
	}
	public void clickOnFirstWebSriesLInk() {
		FirstWebSriesLInk.click();
	}
}
