package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendProjectPage {
WebDriver driver;

@FindBy (xpath="//span[text()='Projects']")
WebElement projectButton;

@FindBy(xpath="//span[text()='All Projects']")
WebElement allProjectsButton;

@FindBy(xpath="//div[@class='title-button-group']//descendant::a")
WebElement addProjectsButton;

@FindBy(id="title")
WebElement titleEditBox;

@FindBy(id="select2-chosen-6")
WebElement clientDropDown;

@FindBy (id="description")
WebElement descriptionEditBox;

@FindBy(xpath="//button[@class='btn btn-primary']")
WebElement submitButton;

@FindBy(xpath="//div[@class='dataTables_filter']//descendant::input")
WebElement searchButtonProjectPage;

@FindBy(xpath="(//a[@class='select2-choice']//child::span)[3]")
WebElement labelDropdownButton;

@FindBy(xpath="//button[@class='btn datepicker-custom-selector']")
WebElement deadLineDropDownButton;

@FindBy(xpath="//button[@class='btn btn-default dropdown-toggle ']")
WebElement statusDropDownButton;

@FindBy(xpath="(//a[@class='delete'])[3]")
WebElement deleteProject;

@FindBy(xpath="(//a[@class='edit'])[3]")
WebElement editProjectButton;

@FindBy(id="select2-chosen-13")
WebElement statusDropDown;

@FindBy (xpath="(//tr[@class='odd']//descendant::a)[2]")
WebElement searchedItem;

@FindBy(id="confirmDeleteButton")
WebElement confirmDelButton;


	public QALegendProjectPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	// TODO Auto-generated constructor stub
}





	public void addProject(String title, int index, String description) {
		PageUtilities.clickOnAnElement(projectButton);
		PageUtilities.clickOnAnElement(allProjectsButton);
		PageUtilities.clickOnAnElement(addProjectsButton);
		PageUtilities.enterText(titleEditBox, title);
		//PageUtilities.selectByIndex(clientDropDown, "6");
		PageUtilities.clickOnAnElement(clientDropDown);
		PageUtilities.arrowKeyDown(driver);
		PageUtilities.enterKeyPress(driver);
		PageUtilities.enterText(descriptionEditBox, description);
		PageUtilities.clickOnAnElement(submitButton);
	}
	
	public void searchProject(String projectName) {
		PageUtilities.clickOnAnElement(projectButton);
		PageUtilities.clickOnAnElement(allProjectsButton);
		PageUtilities.enterText(searchButtonProjectPage, projectName);
	}
	
	public void editProject(String newTitle) {
		PageUtilities.enterText(titleEditBox, newTitle);
		PageUtilities.clickOnAnElement(statusDropDown);
		PageUtilities.arrowKeyDown(driver);
		PageUtilities.arrowKeyDown(driver);
		PageUtilities.enterKeyPress(driver);
		PageUtilities.clickOnAnElement(submitButton);
	}
	
	
	public void deleteProject() {
		PageUtilities.clickOnAnElement(projectButton);
		PageUtilities.clickOnAnElement(allProjectsButton);
		PageUtilities.clickOnAnElement(deleteProject);
		PageUtilities.clickOnAnElement(confirmDelButton);
	}
}
