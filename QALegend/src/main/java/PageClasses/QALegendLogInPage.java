package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendLogInPage {
WebDriver driver;
@FindBy (id = "email")
WebElement userName; 
@FindBy (id = "password")
WebElement passWord;
@FindBy (xpath= "//button[@class='btn btn-lg btn-primary btn-block mt15']")
WebElement logInButton;







public QALegendLogInPage(WebDriver driver) {
	this.driver= driver;
	PageFactory.initElements(driver, this);
	// TODO Auto-generated constructor stub
}







public void logInToQALegend (String username, String password) {
	
	PageUtilities.enterText(userName, username);
	PageUtilities.enterText(passWord, password);
	

	logInButton.click();
	
}
}
