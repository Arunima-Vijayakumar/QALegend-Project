package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG { 
 static ExtentReports extent = new ExtentReports(); //creating object for ExtentReports, which is a aventstack class, from dependency we added on pom.xml
 	
 public static ExtentReports getReportObject() { //return type is not void, but the class name
	 String path= System.getProperty("user.dir")+"\\test-output\\reports.html"; //but this is solely for my laptop, so using .dir for dynamically generating path
	
	 ExtentSparkReporter reporter= new ExtentSparkReporter(path);
	 reporter.config().setReportName("Web Automation Report"); //heading of the report
	 reporter.config().setDocumentTitle("Test Results"); //title of the report
	 
	 extent.attachReporter(reporter); 
	 extent.setSystemInfo("Tester", "Arunima");
	 return extent;
	 
 }

 //Listeners:just like someone who monitors the whole test for us, because looking up to the testcases is timeconsuming\
 
 
}
