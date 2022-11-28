package Selenium.SeleniumFrameworkDesignTests;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Selenium.SeleniumFrameworkDesignTestComponents.BaseTest;
import SeleniumFrameworkDesign.Pageobjects.CartPage;
import SeleniumFrameworkDesign.Pageobjects.Catologue;
import SeleniumFrameworkDesign.Pageobjects.CheckoutPage;
import SeleniumFrameworkDesign.Pageobjects.ConfirmationMessage;
import SeleniumFrameworkDesign.Pageobjects.OrderPage;


public class SubmitOrderTest extends BaseTest{
	String productName = "ZARA COAT 3";
	@Test(dataProvider="getData",groups={"PurchaseOrder"})

	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException  {
		
    	
		Catologue Catologue =  LandingaPage.loginApplication(input.get("email"), input.get("password"));
        List<WebElement>products = Catologue.getProductlist();
        Catologue.addProductToCart(input.get("productName"));
		CartPage CartPage = Catologue.goToCart();
		boolean match = CartPage.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage CheckoutPage =  CartPage.goToCheckOut();
		CheckoutPage.selectCountry("India");
        ConfirmationMessage ConfirmationMessage =CheckoutPage.placeOrder();
        String Message =   ConfirmationMessage.getMessage();
        Assert.assertTrue(Message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        Thread.sleep(3000);
        driver.close();

		
	}

	@Test(dependsOnMethods="submitOrder")
	public void OrderHistory()
	{
		
		Catologue Catologue =  LandingaPage.loginApplication("raji.rajeshwari@gmail.com", "Divya@1503");
		OrderPage OrderPage =  Catologue.goToOrdersPage();
		Assert.assertTrue(OrderPage.verifyOrdersDisplay(productName));
	
		
     }
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException 
	{
		
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Selenium\\SeleniumFrameworkDesignData\\PurchaseOrder.json");
	
		return new Object[] [] {{data.get(0)} , {data.get(1)}};
		
		/*HashMap<String,String> Map = new HashMap<String,String>();
		Map.put("email", "raji.rajeshwari@gmail.com");
		Map.put("password", "Divya@1503");
		Map.put("productName", "ZARA COAT 3");
		
		HashMap<String,String> Map1 = new HashMap<String,String>();
		Map1.put("email", "Eshiva@gmail.com");
		Map1.put("password", "Shiva@1503");
		Map1.put("productName", "IPHONE 13 PRO");
		
		*/
		//return new Object[] [] {{"raji.rajeshwari@gmail.com","Divya@1503" ,"ZARA COAT 3" } , {"Eshiva@gmail.com","Shiva@1503","IPHONE 13 PRO"}};
	}
}
