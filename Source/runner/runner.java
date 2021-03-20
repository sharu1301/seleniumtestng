package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;

//import cucumber.api.junit.*;
import org.testng.annotations.AfterClass;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
//import cucumber.api.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Variables.configProperties;
import Variables.objectProperties;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions( features = {"TestCases"},glue= {"stepdefinition"},tags="@Regression",
plugin= {"json:target/cucumber.json","pretty"})	
   
public class runner extends AbstractTestNGCucumberTests{ 
		
	@BeforeClass
	public static void beforeClass()
	{		
		configProperties.initializePropertyFile();
		objectProperties.initializeObjectProperties();			
	}
	
	@AfterClass
	public static void afterClass()
	{
		
	}
	
}
