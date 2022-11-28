package SeleniumFrameworkDesign.Pageobjects;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import SeleniumFrameworkDesign.Abstractcomponents.Abstract;

public class OrderPage extends Abstract{

	WebDriver driver;
	
	public  OrderPage(WebDriver driver)
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
	
	
	@FindBy(css ="tr td:nth-child(3)")
	List<WebElement> Orders;
	

	
   public boolean verifyOrdersDisplay(String productName ) 
   {
		boolean match = Orders.stream().anyMatch(cart_item->cart_item.getText().equalsIgnoreCase(productName));
		return match;
		
	
	
   }
   
   public  CheckoutPage  goToCheckOut()
   {
	   checkout.click();
	   CheckoutPage CheckoutPage = new CheckoutPage(driver);
	   return CheckoutPage;
	   
   }
   
   
		
}
   