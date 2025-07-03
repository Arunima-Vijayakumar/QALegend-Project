package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendHomePage {
WebDriver driver;
@FindBy (xpath= "//span[text()='Clients']")
WebElement clientOptionButton;




public QALegendHomePage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver= driver;
	PageFactory.initElements(driver, this);
}




public QALegendHomePage clickOnClientOptionButton() {
	PageUtilities.clickOnAnElement(clientOptionButton);
	return this;   //if we do not return anything in a method, chaining of pages--> classname will be the return type
	
}
}
 