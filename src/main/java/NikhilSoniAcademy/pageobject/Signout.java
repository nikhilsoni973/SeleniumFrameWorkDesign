package NikhilSoniAcademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import abstractComponent.AbstractComponent;

public class Signout extends AbstractComponent {
	WebDriver driver;
	public Signout(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
     
	@FindBy(css=".hero-primary")
	WebElement confirmationText;
	
	public String getConfirmationMessage() {
		return confirmationText.getText();
	}
	 
    public void getSuccessMessage() {
    	System.out.println("Signout successfully");
    }
    
    
    

}
