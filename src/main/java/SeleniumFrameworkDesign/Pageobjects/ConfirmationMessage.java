package SeleniumFrameworkDesign.Pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SeleniumFrameworkDesign.Abstractcomponents.Abstract;

public class ConfirmationMessage extends Abstract{

	WebDriver driver;
	
	public  ConfirmationMessage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	
	//Pagefactory
	@FindBy(xpath ="//h1[@class='hero-primary']")
	WebElement Message;
	
	
	  public String  getMessage()
	   {
		  
		  String ConfirmationMsg = Message.getText();
		  System.out.println(ConfirmationMsg);
		  return ConfirmationMsg;
		  
		  
	   }
	
	   
}
   