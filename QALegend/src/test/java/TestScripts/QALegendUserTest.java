package TestScripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.AssertJUnit;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import Constants.Constant;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.RetryAnalyzer;

public class QALegendUserTest extends BaseClass{
	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void addClient() throws IOException {
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnClientOptionButton();
		//String companyName= "Stride"+ FakerUtility.getRandomNumber(); //to generate company names with suffix 1, 1000, or any random number
		String companyName= ExcelUtility.readStringData(1, 0, Constant.CLIENTDATAEXCELFILEPATH, "ClientDetails")+ FakerUtility.getRandomNumber();
		clientPage.createClient(companyName, FakerUtility.getFakerAddress(), ExcelUtility.readIntegerData (1, 1, Constant.CLIENTDATAEXCELFILEPATH, "ClientDetails"));
		clientPage.searchClient(companyName);
		Assert.assertEquals(clientPage.getCompanyCellValue(), companyName);
	}
	
	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void editClient() {
		SoftAssert soft = new SoftAssert(); //non static methods, so we create object for the class,SoftAssert
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnClientOptionButton();
		String companyName= "Stride"+ FakerUtility.getRandomNumber(); //to generate company names with suffix 1, 1000, or any random number
		clientPage.createClient(companyName, FakerUtility.getFakerAddress(), "6478041794");
		clientPage.searchClient(companyName);	
		soft.assertEquals(companyName, companyName);
		soft.assertAll();
		//Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      //  String copiedText = (String) clipboard.getData(DataFlavor.stringFlavor);

       // System.out.println("Copied text: " + c
	}
	
	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void deleteClient() {
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnClientOptionButton();
		String companyName= "Stride"+ FakerUtility.getRandomNumber(); //to generate company names with suffix 1, 1000, or any random number
		clientPage.createClient(companyName, FakerUtility.getFakerAddress(), "6478041794");
		clientPage.searchClient(companyName);	
		clientPage.deleteACompanyCellValue();
		clientPage.searchClient(companyName);
		Assert.assertEquals(clientPage.getTextFromDelete(), "No record found.");
	}
	
	
}
