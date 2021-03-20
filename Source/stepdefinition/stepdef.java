package stepdefinition;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import Variables.configProperties;
import Variables.objectProperties;
import io.cucumber.java.en.*;
//import cucumber.api.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
	
public class stepdef {
		
	WebDriver driver;
	
	@Given("^User navigates to url$")
	public void userNavigatesToUrl()
	{			

		if(configProperties.property.getProperty("BrowserType").equalsIgnoreCase("firefox"))
		{		
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(configProperties.property.getProperty("BrowserType").equalsIgnoreCase("chrome"))
		{			
			WebDriverManager.chromedriver().setup();		
			driver =  new ChromeDriver();		
//below block of code can be used to run execution on selenium grid			
//			ChromeOptions option = new ChromeOptions();
//			
//			try {
//				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),option);
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		else if(configProperties.property.getProperty("BrowserType").equalsIgnoreCase("ie") || configProperties.property.getProperty("BrowserType").equalsIgnoreCase("internetexplorer"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else if(configProperties.property.getProperty("BrowserType").equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.navigate().to(configProperties.property.getProperty("AppURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);				
	}
	
	@When("^User input text \"(.*?)\" on \"(.*?)\"$")
	public void userinputtext(String text, String identifier)
	{		
		
		WebElement webelement = driver.findElement(By.xpath(objectProperties.getElementProperty(identifier)));
		webelement.click();
		webelement.sendKeys(text);
		
	}
	
	@When("^User clicks on \"(.*?)\"$")
	public void userClicks(String identifier)
	{

		WebElement webelement = driver.findElement(By.xpath(objectProperties.getElementProperty(identifier)));
		webelement.click();
	}
	
	@Then("^User verify value of \"(.*?)\" is \"(.*?)\"$")
	public void userVerifyText(String identifier, String expectedval)
	{
		WebElement webelement = driver.findElement(By.xpath(objectProperties.getElementProperty(identifier)));
		Assert.assertEquals(webelement.getText(), expectedval);
	}
	
	@Then("^User closes the browser$")
	public void userClosesBrowser()
	{
		driver.quit();
	}
	
}





