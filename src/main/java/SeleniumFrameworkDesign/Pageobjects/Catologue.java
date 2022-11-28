package SeleniumFrameworkDesign.Pageobjects;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkDesign.Abstractcomponents.Abstract;

public class Catologue extends Abstract{

	WebDriver driver;
	
	public  Catologue(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	// List<WebElement> Products = driver.findElements(By.cssSelector(".mb-3"));
	
	//Pagefactory
	@FindBy(css =".mb-3")
	List<WebElement> Products;
	
	@FindBy(css =".ng-animating")
	WebElement Disappear;
	
	
	By productsby = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	By Invisible = By.cssSelector(".ng-animating");
	
   public List<WebElement> getProductlist()
   {
	   waitToAppear(productsby);
	   return Products;
   }
	

   
   public WebElement getProductByName(String productName)
   {
	   
	   WebElement prod = getProductlist().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);	
		
		return prod;
   }
   
   
   public void addProductToCart(String productName) throws InterruptedException
   {
	WebElement  prod = getProductByName(productName);
	prod.findElement(addToCart).click();
	waitToAppear(toastMessage);
	waitToDisappear(Disappear);
	
	
   }
}


   