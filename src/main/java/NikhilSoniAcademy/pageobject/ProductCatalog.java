package NikhilSoniAcademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import abstractComponent.AbstractComponent;

public class ProductCatalog extends AbstractComponent {
	WebDriver driver;
	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css="ng-animating")
	WebElement animating;
	
	//Locators returntype is By
	By product=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastContainer=By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList() {
		waitForElement(product);
		return products;	
	}
	
	public WebElement getProductByName(List<WebElement> myProduct,String productName) {
		WebElement product=myProduct.stream().filter(s->s.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
		return product;
	}
	
	public void addToCart(WebElement prod) throws InterruptedException {
		//WebElement prod= getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElement(toastContainer);
		waitForElementToDisapper(animating);
	}
	
	
}
