package TestScripts;

import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import Utilities.RetryAnalyzer;

public class QALegendInvoicesTest extends BaseClass {
	
	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void addANewPayment() {
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		invoicesPage.addPayment("1000");
	}
	@Test
	public void addanewInvoice() {
		invoicesPage.addInvoice("Essential invoice number 1");
	}
	@Test
	public void deleteanInvoice() {
		invoicesPage.addInvoice("Essential invoice number 1");
		invoicesPage.deleteInvoice();
	}
}
