package Selenium.SeleniumFrameworkDesignTests;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String Item = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		//LandingaPage LandingaPage = new LandingaPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("raji.rajeshwari@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Divya@1503");
		driver.findElement(By.xpath("//input[@class='btn btn-block login-btn']")).click();
		
		// Get  list of products 
		WebDriverWait  wait = new  WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
				
		List<WebElement> Products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = Products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(Item)).findFirst().orElse(null);	
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		// product added to cart popup
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
			
		// click on cart
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		
		List<WebElement> Cart_items = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		
	
		
		boolean match = Cart_items.stream().anyMatch(cart_item->cart_item.getText().equals(Item));
	
		Assert.assertTrue(match);
		
		
		// click on checkout
				
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		// enter country value
		driver.findElement(By.cssSelector(".form-group input")).sendKeys("India");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')] [2]")).click();
		
	    // place order
		driver.findElement(By.cssSelector(".actions a")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='hero-primary']")));
		// get msg
		String Message = driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
		
		
		Assert.assertTrue(Message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
		
	
		
				

	}

}
