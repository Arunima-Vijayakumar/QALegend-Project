package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {
//all methods are static here 
	public static void clickOnAnElement(WebElement element) {
		element.click();	
	}
	
	public static void enterText(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public static void doubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick().build().perform();
	}
	public static void selectByVisibleText(WebElement element, String value) {
		Select obj = new Select(element);
		obj.selectByVisibleText(value);
	}
	
	public static String getTextFromAnElement(WebElement element) {
		return element.getText();	
	}
	
	public static void dragAndDrop (WebDriver driver, WebElement source, WebElement destination) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
	}
	public static void clearText(WebElement element) {
		element.clear();
	}
	public static void scrollTillElementIsVisible(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver; //converting java compiler driver, to JS
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public static void selectByValue( WebElement element, String value) {
		Select obj= new Select(element);
		obj.selectByValue(value);	
	}
	public static void selectByIndex(WebElement element, String value) {
		Select obj= new Select(element);
		obj.selectByIndex(Integer.parseInt(value));
	}
	public static Boolean isDisplayed(WebElement element) {
		Boolean status= element.isDisplayed();
		return status;
	}
	public static Boolean isEnabled(WebElement element) {
		Boolean status= element.isEnabled();
		return status;
	}
	public static String getAttribute(WebElement element, String value) {
		String attributeValue= element.getAttribute(value);
		return attributeValue;
	}
	public static void assertAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public static void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public static String getTextFromAnaLERT(WebDriver driver) {
		String text= driver.switchTo().alert().getText();
		return text;
	}
	public static void escapeKeyPress(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();
	}
	public static void enterKeyPress(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	public static void controlKeyPress(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.CONTROL).perform();
	}
	public static void altKeyPress(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ALT).perform();
	}
	public static void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}
	public static void clickUsingJSExecutor(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver; //converting java compiler driver, to JS
		 js.executeScript("arguments[0].click", element);
	}
	public static void arrowKeyDown(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).perform();
	}
	
}

