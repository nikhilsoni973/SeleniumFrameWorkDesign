package testcomponent;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import NikhilSoniAcademy.pageobject.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	//All the Generic Code for StandOrderTest Comes here
	public WebDriver driver;
	public Landingpage page;
	public WebDriver initializeDriver() throws IOException{
		/*You can control complete execution by setting global Properities here*/
		//We can access global properities with helpful of properities class
		Properties props = new Properties();
		//Here file will get converted to inputstream Object
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalData.properties");
		props.load(fis);
		//Here we are mentioning that if we are getting browser value from cmd then that browser should used otherwise use the browser
		//Which we mentioned in GlobalDAta.properities but first preferences will be given to cmd value
		String browserName=System.getProperty("browser")!=null?System.getProperty("browser"):props.getProperty("browser");
		
		if(browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			 if(browserName.contains("headless")) {
				 options.addArguments("headless");
			 }
			
			 driver = new ChromeDriver(options);
		}
		else if(browserName.contains("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().window().maximize();
		
		return driver;
	}
	
public List<HashMap<String, String>> getJSONDataToHashMap(String filePath) throws IOException {
		
		//reading JSON to String
		String jsonContent=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);	
		
		//String to HashMap-> With Dependency called Jackson databind
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
		});
		return data;
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public Landingpage launchApplication() throws IOException {
		
		driver=initializeDriver();
		page = new Landingpage(driver);
		page.goTo();
		return page;
	}
	
	  public String getScreenShot(String testName, WebDriver driver) throws IOException {
		  TakesScreenshot ts =(TakesScreenshot)driver;
		  File src=ts.getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(src, new File(System.getProperty("user.dir")+"//reports//"+testName+".png"));
		  //returning path of file
		  return System.getProperty("user.dir")+"//reports//"+testName+".png";
		 
	   }
	   
	

}
