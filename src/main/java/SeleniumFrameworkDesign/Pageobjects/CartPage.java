package SeleniumFrameworkDesign.Pageobjects;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import SeleniumFrameworkDesign.Abstractcomponents.Abstract;

public class CartPage extends Abstract{

	WebDriver driver;
	
	public  CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	//Pagefactory
	@FindBy(xpath ="//div[@class='cartSection']/h3")
	List<WebElement> Cart_items;
	
	@FindBy(css =".totalRow button")
	WebElement checkout;
	
   public boolean verifyProductDisplay(String productName ) 
   {
		boolean match = Cart_items.stream().anyMatch(cart_item->cart_item.getText().equals(productName));
		return match;
		
	
	
   }
   
   public  CheckoutPage  goToCheckOut()
   {
	   checkout.click();
	   CheckoutPage CheckoutPage = new CheckoutPage(driver);
	   return CheckoutPage;
	   
   }
   
   
		
}
   