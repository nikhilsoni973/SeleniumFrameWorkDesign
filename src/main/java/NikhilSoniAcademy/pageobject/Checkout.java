package NikhilSoniAcademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import abstractComponent.AbstractComponent;

public class Checkout extends AbstractComponent {
	WebDriver driver;
	public Checkout(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	 driver.findElement(By.cssSelector(".form-group .text-validated")).sendKeys("ind");
//	    List<WebElement> options=driver.findElements(By.cssSelector("span[class='ng-star-inserted']"));
//	    WebElement countryName=options.stream().filter(s->s.getText().equals("India")).findFirst().orElse(null);
//	    countryName.click();
//	    driver.findElement(By.cssSelector("a[class='btnn action__submit ng-star-inserted']")).click();
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement selectBox;
	
	@FindBy(css="span[class='ng-star-inserted']")
	List<WebElement> listOfCountries;
	
	@FindBy(css="a[class='btnn action__submit ng-star-inserted']")
	WebElement Submit;
	
	public void sendCountry() {
		selectBox.sendKeys("ind");
	}
	
	public List<WebElement> getMeAllCountry(){
		return listOfCountries;
	}
	
	public void getMeSpecificCountry(List<WebElement> options) {
		WebElement country=options.stream().filter(s->s.getText().equals("India")).findFirst().orElse(null);
		country.click();
	}
	
	public Signout submit() {
		Submit.click();
		return new Signout(driver);
	}
	

	 

}
