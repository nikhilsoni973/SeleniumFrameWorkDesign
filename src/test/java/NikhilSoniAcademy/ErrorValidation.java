package NikhilSoniAcademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import NikhilSoniAcademy.pageobject.CartPage;
import NikhilSoniAcademy.pageobject.Landingpage;
import NikhilSoniAcademy.pageobject.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;
import testcomponent.BaseTest;

public class ErrorValidation extends BaseTest {

	@Test(groups= {"errorHandling"},retryAnalyzer= testcomponent.Retry.class)
	public void ErrorValidations() {
		page.loginAction("s@gmail.com", "xxx");
		String message=page.getErrorMessage();
		System.out.println(message);
		Assert.assertEquals("Incorrect email or pas@sword.", message);
	}
	
	@Test
	public void checkingForProducts() throws InterruptedException {
		String productName = "ZARA COAT 3";
		ProductCatalog productsCatalog=page.loginAction("s102@gmail.com", "Nikhil97@");
		// Calling Method in productsCatalog
		List<WebElement> products = productsCatalog.getProductList();
		// System.out.println(products.get(0).getText());
		WebElement mainProduct = productsCatalog.getProductByName(products, productName);
		productsCatalog.addToCart(mainProduct);
		CartPage cart =productsCatalog.goToCart();
		List<WebElement> cartProduct = cart.getProduct();
		System.out.println(cartProduct.get(0).getText());
		boolean isMatch = cart.verifyingTheProduct(cartProduct, productName);
		System.out.println("Product is "+isMatch);
		Assert.assertTrue(isMatch);
		System.out.println(isMatch + " product is Matches");
	}

}
