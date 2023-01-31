package NikhilSoniAcademy.stepdefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import NikhilSoniAcademy.pageobject.CartPage;
import NikhilSoniAcademy.pageobject.Checkout;
import NikhilSoniAcademy.pageobject.Landingpage;
import NikhilSoniAcademy.pageobject.ProductCatalog;
import NikhilSoniAcademy.pageobject.Signout;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testcomponent.BaseTest;

public class StepDefinition extends BaseTest {
	public Landingpage page;
	public ProductCatalog productsCatalog;
	public Signout signout;
	public CartPage cart;
	public Checkout checkout;
	@Given("I landend on page")
	public void I_landend_on_page() throws IOException {
		//code
		page=launchApplication();
	}
	
	@Given("^I Logged in with (.+) and (.+)$")
	public void loginWithCredentials(String username, String password) {
		productsCatalog=page.loginAction(username, password);
	}
	
	@When("^add the product (.+) to cart$")
	public void addProductToCart(String productName) throws InterruptedException {
		List<WebElement> products = productsCatalog.getProductList();
		WebElement mainProduct = productsCatalog.getProductByName(products, productName);
		productsCatalog.addToCart(mainProduct);
	}
	
	@When("^checkout (.+) and submit the order$")
	public void checkoutSubmitOrder(String productName) {
		cart =productsCatalog.goToCart();
		List<WebElement> cartProduct = cart.getProduct();
		boolean isMatch = cart.verifyingTheProduct(cartProduct,productName);
		Assert.assertTrue(isMatch);
		checkout=cart.goToCheckOut();
		checkout.sendCountry();
		List<WebElement> allCountries = checkout.getMeAllCountry();
		checkout.getMeSpecificCountry(allCountries);
		signout=checkout.submit();
	}
   
	@Then("{string} is displayed on confirmation page.")
	public void confirmationMessage(String string) {
		String confirmationMessage=signout.getConfirmationMessage();
		Assert.assertEquals(string, confirmationMessage.trim());
	}
	
    @Then("{string} Error Message is Displayed")
    public void validating(String string) {
    	String message=page.getErrorMessage();
		Assert.assertEquals(string, message);
    }

}
