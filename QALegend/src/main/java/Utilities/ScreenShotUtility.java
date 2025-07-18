package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtility {
	public void captureFailureScreenShot(WebDriver driver, String testcaseName) throws IOException {
		TakesScreenshot scrshot = (TakesScreenshot) driver; //takescreenshot is an interface
		File screenshot = scrshot.getScreenshotAs(OutputType.FILE); //should be type File
		File f1 = new File(System.getProperty("user.dir")+"//OutputScreenShots"); //to a physical form

		if(!f1.exists()) //if the folder already exists, we need not add one 
		{
		f1.mkdirs();
		}
		String timestamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date(0)); //MM- month, mm-minute, ss-seconds
		File finalDestination = new File(System.getProperty("user.dir")+"//OutputScreenShots//"+testcaseName+"_"+timestamp+".png");
		org.openqa.selenium.io.FileHandler.copy(screenshot, finalDestination);

		}

		}


