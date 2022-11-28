package SeleniumFrameworkDesign.Pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SeleniumFrameworkDesign.Abstractcomponents.Abstract;

public class CheckoutPage extends Abstract{

	WebDriver driver;
	
	public  CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	//Pagefactory
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath ="//button[contains(@class,'ta-item')] [2]")
	WebElement select;
	
	@FindBy(css =".actions a")
	WebElement placeorder;
	
	
	

	By results  = By.cssSelector("ta-results");
	By hero =  By.xpath("//h1[@class='hero-primary']");
	
  
   
   
   public  void selectCountry(String countryName)
   {
	   Actions a = new Actions(driver);
	   a.sendKeys(country,countryName).build().perform();
	   waitToAppear(By.cssSelector(".ta-results"));
	   select.click();
	   
   }
   
   public  ConfirmationMessage placeOrder()
   {
	   placeorder.click();
	   ConfirmationMessage ConfirmationMessage = new ConfirmationMessage(driver);
	   return ConfirmationMessage;
	   
	  
   }
   
  
 
}


   