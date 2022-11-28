package Selenium.SeleniumFrameworkDesignTests;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import Selenium.SeleniumFrameworkDesignTestComponents.BaseTest;
import Selenium.SeleniumFrameworkDesignTestComponents.Retry;
import SeleniumFrameworkDesign.Pageobjects.CartPage;
import SeleniumFrameworkDesign.Pageobjects.Catologue;
import SeleniumFrameworkDesign.Pageobjects.OrderPage;


public class ErrorValidationTest extends BaseTest{
	String productName = "ZARA COAT 3";
	@Test(retryAnalyzer=Retry.class)
	public void loginValidation() throws IOException, InterruptedException  {
		
    	 LandingaPage.loginApplication("raji.rajeshwari@gmail.com","Divya@1503");
    	 //Assert.assertEquals("Incorrect email or password.", LandingaPage.errorMsgValidation());
    	 Assert.assertEquals("Login Successfully",LandingaPage.errorMsgValidation());
		
        }
	
	@Test
	public void productValidation() throws IOException, InterruptedException  {
		
    	
		Catologue Catologue =  LandingaPage.loginApplication("raji.rajeshwari@gmail.com", "Divya@1503");
        List<WebElement>products = Catologue.getProductlist();
        Catologue.addProductToCart(productName);
		CartPage CartPage = Catologue.goToCart();
		boolean match = CartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);


}
	
	@Test
	public void OrderHistory()
	{
		
		Catologue Catologue =  LandingaPage.loginApplication("raji.rajeshwari@gmail.com", "Divya@1503");
		OrderPage OrderPage =  Catologue.goToOrdersPage();
		Assert.assertTrue(OrderPage.verifyOrdersDisplay(productName));
	}
}