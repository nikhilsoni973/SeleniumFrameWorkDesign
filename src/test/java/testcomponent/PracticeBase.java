package testcomponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import NikhilSoniAcademy.pageobject.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeBase {
	WebDriver driver;
	public Landingpage page;
	
	public WebDriver initializer() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public Landingpage launchWebApp() {
		//Driver which we got from initialize()-> will get assigned to WebDriver driver ;
		 driver = initializer();
		 page = new Landingpage(driver);
		 page.goTo();
		 return page;
		 
	}

}
