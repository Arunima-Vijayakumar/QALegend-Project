package AutomationCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.internal.IResultListener;

import PageClasses.QALegendClientPage;
import PageClasses.QALegendHomePage;
import PageClasses.QALegendInvoicesPage;
import PageClasses.QALegendLogInPage;
import PageClasses.QALegendProjectPage;
import Utilities.ScreenShotUtility;



public class BaseClass {

	public WebDriver driver;
	public QALegendLogInPage loginPage;
	public QALegendHomePage dashboard;
	public QALegendClientPage clientPage;
	public QALegendProjectPage projectPage;
	public QALegendInvoicesPage invoicesPage;
		public Properties prop;
		public FileInputStream fis;
	
	public WebDriver browserInitialisation (String browserName) throws Exception {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		
		else {
			throw new Exception("Invalid Name Exception");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //should be given in base class, as it is the parent
		
		return driver;
	}

@BeforeMethod (groups= {"regression","smoke"})
@Parameters("Browser")
public void initialisation  (String browserName) throws Exception {
	System.out.println("before method");
	driver= browserInitialisation (browserName);
	
	fis= new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/ApplicationData.properties");
	prop= new Properties();
	prop.load(fis);
	
	loginPage = new QALegendLogInPage(driver);
	dashboard = new QALegendHomePage(driver);
	clientPage= new QALegendClientPage(driver);
	projectPage = new QALegendProjectPage(driver);
	invoicesPage= new QALegendInvoicesPage(driver);

	driver.get(prop.getProperty("url"));
	
	driver.manage().window().maximize();
}

@AfterMethod (groups= {"regression", "smoke"})
public void afterMethod(ITestResult itresult) throws IOException{ //screenshot
	if (itresult.getStatus() == ITestResult.FAILURE) {
		ScreenShotUtility ss = new ScreenShotUtility();
		ss.captureFailureScreenShot(driver, itresult.getName());
	}
	if (driver!=null) {
		driver.quit();
	}
}
}


