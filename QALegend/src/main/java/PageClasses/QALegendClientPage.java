package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendClientPage {
WebDriver driver;
@FindBy (xpath= "//a[@class='btn btn-default']")
WebElement addClientButton;
@FindBy (id="company_name")
WebElement companyNameField;
@FindBy(id= "address")
WebElement addressField;
@FindBy (id= "phone")
WebElement phoneNumberField;
@FindBy (xpath= "//button[@class='btn btn-primary']")
WebElement saveButton;
@FindBy (xpath= "//div[@id='client-table_filter']//descendant:: input")
WebElement searchButton;
@FindBy (xpath= "(//tr[@class='odd' or @class='even']//descendant::a)[1]")
WebElement clientCell;
@FindBy (id="country")
WebElement countryNameField;
@FindBy(id= "city")
WebElement cityFiled;
@FindBy (id= "state")
WebElement stateField;

@FindBy(xpath="(//a[@class='delete'])[1]")
WebElement deleteButton1;

@FindBy (id= "confirmDeleteButton")
WebElement confirmDeleteButton;

@FindBy(xpath="//td[text()='No record found.']")
WebElement noRecordsFound;



public QALegendClientPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver= driver;
	PageFactory.initElements(driver, this);
}



public QALegendClientPage createClient(String companyName, String address, String phone) {
	PageUtilities.clickOnAnElement(addClientButton);
	PageUtilities.enterText(companyNameField, companyName);
	PageUtilities.enterText(addressField, address);
	phoneNumberField.sendKeys(phone);
	saveButton.click();
	return this; //chaining of methods
	
}

public void searchClient(String clientName) {
	WaitUtility.waitForElementToBeInVisible(driver, saveButton);
	PageUtilities.clearText(searchButton);
	PageUtilities.enterText(searchButton, clientName);
}

public String getCompanyCellValue() {
	String companyValue= PageUtilities.getTextFromAnElement(clientCell);
	return companyValue;
}

public String getCityNameValue() {
	String cityName = PageUtilities.getTextFromAnElement(cityFiled);
	return cityName;
}


public String getAddressCellValue() {
	String addressCellValue = PageUtilities.getTextFromAnElement(addressField);
	return addressCellValue;	
}

public String getStateCellValue() {
	String stateName = PageUtilities.getTextFromAnElement(stateField);
	return stateName;	
}

public String getCountryCellValue() {
	String countryNmae= PageUtilities.getTextFromAnElement(countryNameField);
	return countryNmae;
}
public void deleteACompanyCellValue() {
	PageUtilities.clickOnAnElement(deleteButton1);
	PageUtilities.clickOnAnElement(confirmDeleteButton);
}
public String getTextFromDelete() {
	return	PageUtilities.getTextFromAnElement(noRecordsFound);
}
}
