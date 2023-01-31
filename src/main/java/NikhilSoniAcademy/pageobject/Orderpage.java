package NikhilSoniAcademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import abstractComponent.AbstractComponent;

public class Orderpage extends AbstractComponent {
	WebDriver driver;
	public Orderpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderProducts;
	
	public List<WebElement> getProduct() {
		return orderProducts;
	}
	
	public boolean verifyingTheOrder(List<WebElement> orderProducts,String productName) {
		 Boolean isMatch=orderProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		 return isMatch;
	}
	
	
}
