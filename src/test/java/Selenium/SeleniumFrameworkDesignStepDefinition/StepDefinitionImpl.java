package Selenium.SeleniumFrameworkDesignStepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Selenium.SeleniumFrameworkDesignTestComponents.BaseTest;
import SeleniumFrameworkDesign.Pageobjects.CartPage;
import SeleniumFrameworkDesign.Pageobjects.Catologue;
import SeleniumFrameworkDesign.Pageobjects.CheckoutPage;
import SeleniumFrameworkDesign.Pageobjects.ConfirmationMessage;
import SeleniumFrameworkDesign.Pageobjects.LandingaPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest {
	
	

	public LandingaPage LandingaPage;
	public Catologue Catologue;
	public ConfirmationMessage ConfirmationMessage;
	
	@Given("I landed on ecommerce website page")
	
	public void I_landed_on_ecommerce_website_page() throws IOException
	{
		LandingaPage = Launch();
		
	}
	
    @Given("^Logged in with username (.+) and password (.+)$")
    
    public void Logged_in_with_username_and_password(String userName ,String password)
    {
    	Catologue =  LandingaPage.loginApplication(userName , password);
        
    }
    
    @When("^I add product (.+) to cart$")
    
    public void add_product_to_cart(String productName) throws InterruptedException
    {
    	List<WebElement>products = Catologue.getProductlist();
        Catologue.addProductToCart(productName);
    }
    
    @When("^Checkout (.+) and submit the order$")
    
    public void Checkout_and_submit_the_order(String productName)
    {
    	CartPage CartPage = Catologue.goToCart();
		boolean match = CartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage CheckoutPage =  CartPage.goToCheckOut();
		CheckoutPage.selectCountry("India");
        ConfirmationMessage =CheckoutPage.placeOrder();
   	
    }
    
    @Then("{string} message displayed on ConfirmationPage")
    
    public void message_displayed_on_ConfirmationPage(String string) 
    {
    	String Message =   ConfirmationMessage.getMessage();
        Assert.assertTrue(Message.equalsIgnoreCase(string));
        driver.close();
    }
    
    
    
    @Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {
       
    	Assert.assertEquals( strArg1, LandingaPage.errorMsgValidation());
    	driver.close();
    }

    
    
    
}
