package abstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import NikhilSoniAcademy.pageobject.CartPage;
import NikhilSoniAcademy.pageobject.Orderpage;
import NikhilSoniAcademy.pageobject.Signout;

public class AbstractComponent {
	
	//driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();

	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="button[routerlink*='cart']")
	WebElement cartAction;

	
	@FindBy(css="button[routerlink*='myorders']")
	WebElement myOrders;
	//Here we can put all reusable code
	
	//li button i[css='4']
	@FindBy(css="i[class='fa fa-sign-out']")
	WebElement signout;
	
	public void waitForElement(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForWebElement(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDisapper(WebElement findBy) throws InterruptedException {
		Thread.sleep(2000);
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.invisibilityOf(findBy));
	}
	
	public CartPage goToCart() {
		cartAction.click();
		return new CartPage(driver);
	}
	
	public Orderpage goToOrder() {
		myOrders.click();
		return new Orderpage(driver);
	}
	
	public Signout signout() {
		signout.click();
		return new Signout(driver);
	}
	
	//w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("ng-animating"))));
	
	

}
