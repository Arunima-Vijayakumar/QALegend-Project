package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

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

@FindBy(xpath="(//a[@class='delete'])[1]")
WebElement deleteProject;

@FindBy(xpath="//a[@class='edit']")
WebElement editProjectButton;

@FindBy(id="select2-chosen-13")
WebElement statusDropDown;

@FindBy (xpath="(//tr[@class='odd']//descendant::a)[2]")
WebElement searchedItem;

@FindBy(id="confirmDeleteButton")
WebElement confirmDelButton;

@FindBy(xpath="")
WebElement searchedProName;

@FindBy(xpath="//div[@class='page-title clearfix'] //child::h1")
WebElement titleBlock;

@FindBy(xpath="//h4[text()='Add project']")
WebElement addprojecttitle;


@FindBy(xpath="//td[text()='No record found.']")
WebElement norecordfound;

@FindBy(xpath="(//tr[@class='odd' or @class='even']//descendant::td)[2]")
WebElement projectCell;

@FindBy(xpath="//span[text()='Tasks']")
WebElement tasksButton;

@FindBy(xpath="(//a[@title='Add task'])[2]")
WebElement addTaskButton;

@FindBy(xpath="//input[@id='title']")
WebElement titleBox;

@FindBy(id="select2-chosen-14")
WebElement projectDropDown;

@FindBy(xpath="(//tr[@class='odd' or @class='even']//descendant::a)[2]")
WebElement taskCell;

	public QALegendProjectPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	// TODO Auto-generated constructor stub
}



public QALegendProjectPage clickOnProjectButton() {
	PageUtilities.clickOnAnElement(projectButton);
	return this;
}

public void clickonAllProjectsButton() {
	PageUtilities.clickOnAnElement(allProjectsButton);
	
}
public String getAllprojectsTitle() {
	return	PageUtilities.getTextFromAnElement(titleBlock);
}

public void clickOnTasksButton() {
	PageUtilities.clickOnAnElement(tasksButton);
}

public void clickonAddTaskButton() {
	PageUtilities.clickOnAnElement(addTaskButton);
	
}
public void addingATask(String title) {
	PageUtilities.enterText(titleBox, title);
	PageUtilities.clickOnAnElement(projectDropDown);
	PageUtilities.arrowKeyDown(driver);
	PageUtilities.arrowKeyDown(driver);
	PageUtilities.arrowKeyDown(driver);
	PageUtilities.enterKeyPress(driver);
	PageUtilities.clickOnAnElement(submitButton);
	
}
public String getTextFromTaskCell() {
	return	PageUtilities.getTextFromAnElement(taskCell);
}

public String getTextFromDelete() {
	return	PageUtilities.getTextFromAnElement(norecordfound);
}
	public void addProject(String title, int index, String description) {
	
	
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
	WaitUtility.waitForElementToBeInVisible(driver, submitButton);
	PageUtilities.clearText(searchButtonProjectPage);
		PageUtilities.enterText(searchButtonProjectPage, projectName);
		
	}
	public void clickOnSearchedPorject() {
		PageUtilities.clickOnAnElement(searchedProName);
	}
	
	public String getProName() {
		String name= PageUtilities.getTextFromAnElement(searchedProName);
		return name;
	}
	
	public String getProjectCellValue() {
		String projectName= PageUtilities.getTextFromAnElement(projectCell);
		return projectName;
	}
	public void editProject(String newTitle) {
		WaitUtility.waitForElementToBeInVisible(driver, submitButton);
		PageUtilities.clickOnAnElement(editProjectButton);
		
		PageUtilities.clearText(titleEditBox);
		PageUtilities.enterText(titleEditBox, newTitle);
		PageUtilities.clickOnAnElement(submitButton);
	}
	
	
	public void deleteProject() {
		
		PageUtilities.clickOnAnElement(deleteProject);
		PageUtilities.clickOnAnElement(confirmDelButton);
	}
	
	public String getTextDelete() {
		return	PageUtilities.getTextFromAnElement(norecordfound);
	}
}
