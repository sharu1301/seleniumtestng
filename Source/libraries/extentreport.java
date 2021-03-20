package libraries;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import gherkin.formatter.model.Feature;



public class extentreport {

	public static ExtentReports extent;
	public static ExtentTest extenttest;
	public static ExtentTest extentstep;
	public static void initializeExtentReport()
	{
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		
	}
	
	public static void createfeature()
	{
		
	}
	
	public static void createTest(Feature feature)
	{
		extenttest = extent.createTest(feature.getName());
	}
	
	public static void createNode(String scenario)
	{
		extenttest.createNode(scenario);
	}
	
	public void passed(String description)
	{
		extentstep.pass(description);
	}
	
	public void information(String description)
	{
		extentstep.info(description);
	}
	
	public void failed(String description)
	{
		extentstep.fail(description);
	}
	
	public void warning(String description)
	{
		extentstep.warning(description);
	}
	
	public void flushreport()
	{
		extent.flush();
	}
	
}
