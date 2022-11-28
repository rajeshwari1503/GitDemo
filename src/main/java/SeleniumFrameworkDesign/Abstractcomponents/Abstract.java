package SeleniumFrameworkDesign.Abstractcomponents;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumFrameworkDesign.Pageobjects.CartPage;
import SeleniumFrameworkDesign.Pageobjects.OrderPage;

public class Abstract {
	
	WebDriver driver;

	public Abstract(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	//Pagefactory
		@FindBy(css = "[routerlink*='cart']")
		WebElement CartHeader;
		
		@FindBy(css = "[routerlink*='myorders']")
		WebElement OrderHeader;
		
		
		
	public void waitToAppear(By findBy) 
	{
        WebDriverWait  wait = new  WebDriverWait(driver, Duration.ofSeconds(10));
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
				
	}
	
	public void waitTo(WebElement findBy) 
	{
        WebDriverWait  wait = new  WebDriverWait(driver, Duration.ofSeconds(10));
	
		wait.until(ExpectedConditions.visibilityOf(findBy));
				
	}
	public CartPage goToCart()
	{
		CartHeader.click();
		CartPage CartPage = new CartPage(driver);
		return CartPage;
	}
	
	public OrderPage goToOrdersPage()
	{
		OrderHeader.click();
		OrderPage OrderPage = new OrderPage(driver);
		return OrderPage;
	}
	
	public void waitToDisappear(WebElement ele) throws InterruptedException 
	{
		Thread.sleep(3000);
       // WebDriverWait  wait = new  WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.invisibilityOf(ele));
				
	}
   
	
	
	
}


