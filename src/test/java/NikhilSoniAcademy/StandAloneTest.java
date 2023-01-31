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

import NikhilSoniAcademy.pageobject.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//To Setup chromeDriver without Even installing chromeDriver in Local Machine
		String productName="ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Landingpage page = new Landingpage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("s101@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Nikhil97@");
		driver.findElement(By.id("login")).click();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
//		Here We Will get one product with text containing ZARA
//		WebElement product=products.stream().filter(s->s.findElement(By.tagName("b")).getText().equals(productName))
//		.findFirst().orElse(null);
//		System.out.println(product.getText());
//		product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//		
//		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//		ng-animating
//		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("ng-animating"))));
//		
//	    driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
//	    
//	    List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
//	    Boolean isMatch=cartProducts.stream().anyMatch(s->s.getText().equals(productName));
//	    Assert.assertTrue(isMatch);
//	    System.out.println(isMatch+" product is Matches");
//	    driver.findElement(By.cssSelector("li[class='totalRow'] button")).click();
//	    driver.findElement(By.cssSelector(".form-group .text-validated")).sendKeys("ind");
//	    List<WebElement> options=driver.findElements(By.cssSelector("span[class='ng-star-inserted']"));
//	    WebElement countryName=options.stream().filter(s->s.getText().equals("India")).findFirst().orElse(null);
//	    countryName.click();
//	    driver.findElement(By.cssSelector("a[class='btnn action__submit ng-star-inserted']")).click();
//	   


	   List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	   WebElement product=products.stream().filter(s->s.findElement(By.tagName("b")).getText().contains(productName)).findFirst().orElse(null);
	   System.out.println(product.getText());
	product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		

	}

}
