package NikhilSoniAcademy;

import java.io.File;
import org.openqa.selenium.io.FileHandler;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import NikhilSoniAcademy.pageobject.CartPage;
import NikhilSoniAcademy.pageobject.Checkout;
import NikhilSoniAcademy.pageobject.Landingpage;
import NikhilSoniAcademy.pageobject.Orderpage;
import NikhilSoniAcademy.pageobject.ProductCatalog;
import NikhilSoniAcademy.pageobject.Signout;
import io.github.bonigarcia.wdm.WebDriverManager;
import testcomponent.BaseTest;

public class StandOrderTest extends BaseTest {
	   String productName = "ZARA COAT 3";
	   @Test(dataProvider="getData",groups= {"purchaseOrder"})
	   public void StandOrderTests(HashMap<String,String> input) throws InterruptedException, IOException {
		
		ProductCatalog productsCatalog=page.loginAction(input.get("email"), input.get("password"));
		// Calling Method in productsCatalog
		List<WebElement> products = productsCatalog.getProductList();
		// System.out.println(products.get(0).getText());
		WebElement mainProduct = productsCatalog.getProductByName(products, input.get("product"));
		productsCatalog.addToCart(mainProduct);
		CartPage cart =productsCatalog.goToCart();
		List<WebElement> cartProduct = cart.getProduct();
		System.out.println(cartProduct.get(0).getText());
		boolean isMatch = cart.verifyingTheProduct(cartProduct, input.get("product"));
		Assert.assertTrue(isMatch);
		System.out.println(isMatch + " product is Matches");
		Checkout checkout=cart.goToCheckOut();
		checkout.sendCountry();
		List<WebElement> allCountries = checkout.getMeAllCountry();
		checkout.getMeSpecificCountry(allCountries);
		Signout signout=checkout.submit();
		String confirmationMessage=signout.getConfirmationMessage();
		Assert.assertEquals("Thankyou for the order.", confirmationMessage.trim());

//	    driver.findElement(By.cssSelector(".form-group .text-validated")).sendKeys("ind");
//	    List<WebElement> options=driver.findElements(By.cssSelector("span[class='ng-star-inserted']"));
//	    WebElement countryName=options.stream().filter(s->s.getText().equals("India")).findFirst().orElse(null);
//	    countryName.click();
//	    driver.findElement(By.cssSelector("a[class='btnn action__submit ng-star-inserted']")).click();
//	   

//	   List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
//	   WebElement product=products.stream().filter(s->s.findElement(By.tagName("b")).getText().contains(productName)).findFirst().orElse(null);
//	   System.out.println(product.getText());
//	product.findElement(By.cssSelector(".card-body button:last-of-type")).click();

	}
	    @Test(dependsOnMethods= {"StandOrderTests"})
	   public void verifyingOrderPage() {
		   
			ProductCatalog productsCatalog = page.loginAction("s101@gmail.com", "Nikhil97@");
			Orderpage orderpage = productsCatalog.goToOrder();
			List<WebElement> allOrders = orderpage.getProduct();
			boolean isMatch = orderpage.verifyingTheOrder(allOrders, productName);
			Assert.assertTrue(isMatch);
			Signout signout = orderpage.signout();
			signout.getSuccessMessage();
		  
		   
	   }
	   
	   @DataProvider
	   public Object[][] getData() throws IOException {
		   //Here we giving 2 set of data-> row 
		   //3 value-> column;
		   //We can even send hashMap
		   
		   //This is First Way
		  // return new Object[][] {{"s101@gmail.com","Nikhil97@"},{"s102@gmail.com","Nikhil97@"}};
		   
		   //This is Second Way
//		   HashMap<String,String> map = new HashMap<String,String>();
//		   map.put("email", "s101@gmail.com");
//		   map.put("password", "Nikhil97@");
//		   map.put("product","ZARA COAT 3");
//		   
//		   HashMap<String,String> map1 = new HashMap<String,String>();
//		   map1.put("email", "s102@gmail.com");
//		   map1.put("password", "Nikhil97@");
//		   map1.put("product","ADIDAS ORIGINAL");
		   //return new Object[][] {{map},{map1}}
		   
		   //Third way and more optimised Way
		  List<HashMap<String,String>> data=getJSONDataToHashMap("C:\\Users\\sonin\\eclipse-workspace\\SeleniumFramworkDesign\\src\\test\\java\\NikhilSoniAcademy\\data\\purchaseOrder.json");
		   
		   return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)}};
		  		   
		   
	   }
	   
	   @DataProvider
	   public void getSomeData() {
		   
	   }
	   
	   
}
	   
	  



