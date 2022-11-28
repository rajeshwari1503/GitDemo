package SeleniumFrameworkDesign.Pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SeleniumFrameworkDesign.Abstractcomponents.Abstract;

public class LandingaPage extends Abstract{


	WebDriver driver;
	
	public  LandingaPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	//WebElement Username=  driver.findElement(By.id("userEmail"));
	
	//Pagefactory
	@FindBy(id ="userEmail")
	WebElement userEmail;
	
	@FindBy(id ="userPassword")
	WebElement Passwordele;
	
	@FindBy(xpath ="//input[@class='btn btn-block login-btn']")
	WebElement login;
	
	@FindBy(css ="[class*='flyInOut']")
	WebElement errorMsg;
	
	
    public Catologue loginApplication(String email, String password)
    {
    	
    	userEmail.sendKeys(email);
    	Passwordele.sendKeys(password);
    	login.click();
    	Catologue Catologue = new Catologue(driver);
		return Catologue;
    	
    }
    
    
    public String errorMsgValidation()
    {
    	waitTo(errorMsg);
    	return errorMsg.getText();
    	  
    }

	
	public void  goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	

}


   