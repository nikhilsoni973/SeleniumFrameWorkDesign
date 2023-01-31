package NikhilSoniAcademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class Landingpage extends AbstractComponent {
	WebDriver driver;
	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		//This statement is used to construct webelement 
		PageFactory.initElements(driver, this);
	}

	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	
	//alternative Way (pageFactory)
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	//WebElement userPassword=driver.findElement(By.id("userPassword"));
	
	@FindBy(id="login")
	WebElement login;
	//WebElement login= driver.findElement(By.id("login"));
	
	public ProductCatalog loginAction(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		return new ProductCatalog(driver);
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	//.ng-tns-c4-2.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public String getErrorMessage() {
		waitForWebElement(errorMessage);
		return errorMessage.getText();
	}
	
}
