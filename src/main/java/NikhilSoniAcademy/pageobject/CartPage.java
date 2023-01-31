package NikhilSoniAcademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import abstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	 
//    List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
//    Boolean isMatch=cartProducts.stream().anyMatch(s->s.getText().equals(productName));
//    Assert.assertTrue(isMatch);
//    System.out.println(isMatch+" product is Matches");
//    driver.findElement(By.cssSelector("li[class='totalRow'] button")).click();
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css="li[class='totalRow'] button")
	WebElement checkout;
	
	public List<WebElement> getProduct() {
		return cartProducts;
	}
	
	public boolean verifyingTheProduct(List<WebElement> cartProducts,String productName) {
		 Boolean isMatch=cartProducts.stream().anyMatch(s->s.getText().equals(productName));
		 return isMatch;
	}
	
	public Checkout goToCheckOut() {
		checkout.click();
		return new Checkout(driver);
	}

}
