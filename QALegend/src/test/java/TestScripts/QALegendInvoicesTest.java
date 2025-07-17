package TestScripts;

import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import Utilities.RetryAnalyzer;

public class QALegendInvoicesTest extends BaseClass {
	

	@Test  (retryAnalyzer = RetryAnalyzer.class, groups= {"regression"})
	public void addanewInvoice() {
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		invoicesPage.clickOnInvoicesOption();
		invoicesPage.clickOnAddInvoiceButton();
		invoicesPage.addInvoice(prop.getProperty("notes"));
		Assert.assertEquals(invoicesPage.getInvoice(), true);
	}
	
	@Test (retryAnalyzer = RetryAnalyzer.class, groups= {"regression"})
	public void addANewPayment() {
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		
		invoicesPage.clickOnInvoicesOption();
		invoicesPage.clickOnAddInvoiceButton();
		invoicesPage.addInvoice(prop.getProperty("notes"));
		invoicesPage.clickOnAddPaymentButton();
		invoicesPage.addPayment(prop.getProperty("amountToPay"));
		Assert.assertEquals(invoicesPage.getPaymentDoneText(), true);
	}
	
	@Test  (retryAnalyzer = RetryAnalyzer.class, groups= {"regression"})
	public void deleteanInvoice() {
		
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		invoicesPage.clickOnInvoicesOption();
		invoicesPage.clickOnAddInvoiceButton();
		invoicesPage.addInvoice(prop.getProperty("notes"));
		String invNum= invoicesPage.getInvoiceNum();
		invoicesPage.clickOnInvoicesOption();
		invoicesPage.searchInvoice(invNum);
		invoicesPage.clickOnSettings();
		invoicesPage.clickOnDelete();
		Assert.assertEquals(invoicesPage.getTextDelete(), "No record found.");
	}
}
