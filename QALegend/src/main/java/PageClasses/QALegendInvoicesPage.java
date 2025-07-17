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

@FindBy(xpath="(//div[@class='title-button-group']//a[@class='btn btn-default'])[2]")
WebElement addPaymentButton;

@FindBy (id= "select2-chosen-7")
WebElement invoiceDropdown;

@FindBy(id="invoice_payment_date")
WebElement paymentDateButton;

@FindBy(xpath="//td[@class='today active day']")
WebElement todaysDate;

@FindBy(id="invoice_payment_amount")
WebElement amountTextBox;

@FindBy(xpath="//button[@class='btn btn-primary']")
WebElement saveButton;

@FindBy(xpath="//a[@title='Add invoice']")
WebElement addInvoiceButton;

@FindBy(id="invoice_bill_date")
WebElement billDate;

@FindBy(id="invoice_due_date")
WebElement dueDate;

@FindBy(xpath="(//span[@class='select2-arrow'])[4]")
WebElement clientDropDown;

@FindBy(id="select2-chosen-19")
WebElement taxDropDown;

@FindBy(id="invoice_note")
WebElement note;

@FindBy(xpath="//button[@class='btn btn-primary']")
WebElement saveinvoiceButton;

@FindBy(xpath="//span[@class='dropdown inline-block open']//child::button")
WebElement settingsButton;


@FindBy(xpath="(//td[@class='today active day']//following::td)[1]")
WebElement dateTomorrow;

@FindBy(xpath="//span[@class='invoice-info-title']")
WebElement invoiceGreen;

@FindBy(xpath="//span[text()='Fully paid']")
WebElement fullyPaidGreen;

@FindBy(xpath="//span[@class='invoice-info-title']")
WebElement invoiceNumber;

@FindBy(xpath="//div[@id='monthly-invoice-table_filter']//descendant::input")
WebElement searchInvoice;

@FindBy(xpath="(//span[@class='caret'])[2]")
WebElement settingsIcon;

@FindBy(xpath="//a[@title='Delete invoice']")
WebElement deleteButton;

@FindBy(xpath="//td[text()='No record found.']")
WebElement norecordfound;

public QALegendInvoicesPage(WebDriver driver) {

	this.driver= driver;
	PageFactory.initElements(driver, this);
	// TODO Auto-generated constructor stub
}

public void clickOnInvoicesOption() {
	PageUtilities.clickOnAnElement(invoicesButton);
}

public void clickOnAddPaymentButton() {
	WaitUtility.waitForElementToBeClickable(driver, addPaymentButton);
	PageUtilities.clickOnAnElement(addPaymentButton);
}


public void clickOnAddInvoiceButton() {

	PageUtilities.clickOnAnElement(addInvoiceButton);

}
public void clickOnSettings() {
	PageUtilities.clickOnAnElement(settingsIcon);
}

public void clickOnDelete() {
	PageUtilities.clickOnAnElement(deleteButton);
}
public void searchInvoice(String invoice) {

	PageUtilities.enterText(searchInvoice, invoice);

}
public String getTextDelete() {
	return	PageUtilities.getTextFromAnElement(norecordfound);
}


public void addPayment(String amountforPayment) {

	

	PageUtilities.clickOnAnElement(paymentDateButton);
	
	PageUtilities.enterKeyPress(driver);
	PageUtilities.enterText(amountTextBox, amountforPayment);
	PageUtilities.clickOnAnElement(saveButton);
}
	public void addInvoice(String notes) {
		
		PageUtilities.clickOnAnElement(billDate);
		PageUtilities.enterKeyPress(driver);
		PageUtilities.clickOnAnElement(dueDate);
		PageUtilities.rightArrowPress(driver);
		PageUtilities.enterKeyPress(driver);
		
		PageUtilities.clickOnAnElement(clientDropDown);
		PageUtilities.arrowKeyDown(driver);
		PageUtilities.enterKeyPress(driver);
		
		PageUtilities.enterText(note, notes);
		PageUtilities.clickOnAnElement(saveinvoiceButton);
		
	}
	public Boolean getInvoice() {
		return PageUtilities.isDisplayed(invoiceGreen);
	}
	
	public Boolean getPaymentDoneText() {
		return PageUtilities.isDisplayed(fullyPaidGreen);
	}
	
	public void deleteInvoice() {
		PageUtilities.clickOnAnElement(settingsButton);
		PageUtilities.clickOnAnElement(deleteButton);
	}
	
	public String getInvoiceNum() {
	return	PageUtilities.getTextFromAnElement(invoiceNumber);
	}
}
