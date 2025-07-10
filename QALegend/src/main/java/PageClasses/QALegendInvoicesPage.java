package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendInvoicesPage {
	
WebDriver driver;

@FindBy(xpath="//span[text()='Invoices']")
WebElement invoicesButton;

@FindBy(xpath="(//div[@class='title-button-group']//child::a)[1]")
WebElement addPaymentButton;

@FindBy (id= "select2-chosen-7")
WebElement invoiceDropdown;

@FindBy(xpath="//input[@id='invoice_payment_date']")
WebElement paymentDateButton;

@FindBy(xpath="//td[@class='today active day']")
WebElement todaysDate;

@FindBy(id="invoice_payment_amount")
WebElement amountTextBox;

@FindBy(xpath="//button[@class='btn btn-primary']")
WebElement saveButton;

@FindBy(xpath="//a[@class='btn btn-default mb0']")
WebElement addInvoiceButton;

@FindBy(id="invoice_bill_date")
WebElement billDate;

@FindBy(id="select2-chosen-19")
WebElement clientDropDown;

@FindBy(id="select2-chosen-19")
WebElement taxDropDown;

@FindBy(id="invoice_note")
WebElement note;

@FindBy(xpath="//button[@class='btn btn-primary']")
WebElement saveinvoiceButton;

@FindBy(xpath="//span[@class='dropdown inline-block open']//child::button")
WebElement settingsButton;

@FindBy(xpath="(//a[@class='delete'])[1]")
WebElement deleteButton;


public QALegendInvoicesPage(WebDriver driver) {

	this.driver= driver;
	PageFactory.initElements(driver, this);
	// TODO Auto-generated constructor stub
}

public void addPayment(String amountforPayment) {
	PageUtilities.clickOnAnElement(invoicesButton);
	PageUtilities.clickOnAnElement(addPaymentButton);
	PageUtilities.clickOnAnElement(invoiceDropdown);
	PageUtilities.arrowKeyDown(driver);
	PageUtilities.arrowKeyDown(driver);
	PageUtilities.enterKeyPress(driver);
	PageUtilities.clickOnAnElement(paymentDateButton);
	WaitUtility.waitForElementToBeVisible(driver, todaysDate);
	PageUtilities.clickOnAnElement(todaysDate);
	PageUtilities.enterKeyPress(driver);
	PageUtilities.enterText(amountTextBox, amountforPayment);
	PageUtilities.clickOnAnElement(saveButton);
}
	public void addInvoice(String notes) {
		PageUtilities.clickOnAnElement(addInvoiceButton);
		PageUtilities.clickOnAnElement(billDate);
		PageUtilities.clickOnAnElement(clientDropDown);
		PageUtilities.arrowKeyDown(driver);
		PageUtilities.enterKeyPress(driver);
		PageUtilities.clickOnAnElement(taxDropDown);
		PageUtilities.arrowKeyDown(driver);
		PageUtilities.enterKeyPress(driver);
		PageUtilities.enterText(note, notes);
		PageUtilities.clickOnAnElement(saveinvoiceButton);
	}
	public void deleteInvoice() {
		PageUtilities.clickOnAnElement(settingsButton);
		PageUtilities.clickOnAnElement(deleteButton);
	}
}
