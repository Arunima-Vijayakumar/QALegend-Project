package TestScripts;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import AutomationCore.BaseClass;
import Utilities.ExtentReportNG;

public class Listeners extends BaseClass implements ITestListener  { //interface that has all abstract methods, right click on class, source, and implement methods
//extends baseclass for the driver 
	ExtentTest test;
	ExtentReports extent= ExtentReportNG.getReportObject(); //returns the stuff from getreportobject, and needs to be stored here, so same data type, which is the classname
	ThreadLocal <ExtentTest> extenttest= new ThreadLocal<ExtentTest>(); //for managing the threads, so that results for parallel testing do not overlap
	
	
	
	@Override
	public void onTestStart(ITestResult result) { //to generate fields, or titles 
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test= extent.createTest(result.getMethod().getMethodName());   //result parameter from Listener 
		extenttest.set(test); //to generate field
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		extenttest.get().log(Status.PASS, "Test Case Passed"); //marking a test as pass, so on test success		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		extenttest.get().log(Status.FAIL, "Test Case Failed"); 
		extenttest.get().fail(result.getThrowable()); //to let the user know of why the testcase failed, the reason
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		extenttest.get().log(Status.SKIP, "Test Case Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) { 
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		extent.flush();  //to avoid unwanted memory usage, because listeners keep running even though the testcases have run
	}

}
