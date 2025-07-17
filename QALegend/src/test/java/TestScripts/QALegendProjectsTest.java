package TestScripts;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import Constants.Constant;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.RetryAnalyzer;
import Utilities.WaitUtility;
import net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection;

public class QALegendProjectsTest extends BaseClass{
	@Test (retryAnalyzer = RetryAnalyzer.class, groups= {"smoke", "regression"})
	public void addANewProject() throws IOException {
		
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		projectPage.clickOnProjectButton();
		projectPage.clickonAllProjectsButton();
		String proName= ExcelUtility.readStringData(1, 0, Constant.PROJECTDATAEXCELFILEPATH, "ProjectDetails")+FakerUtility.getRandomNumber();
		String description=  ExcelUtility.readStringData(1, 1, Constant.PROJECTDATAEXCELFILEPATH, "ProjectDetails");
		
		projectPage.addProject(proName, 7, description);
		
		projectPage.searchProject(proName);
		System.out.println(projectPage.getProjectCellValue());
		Assert.assertEquals(projectPage.getProjectCellValue(), proName);
		
		//soft.assertEquals(actual, expected);
		//soft.assertAll();
	}
	
	
	@Test (retryAnalyzer = RetryAnalyzer.class, groups= {"regression"})
	public void editAProject() throws IOException {
		
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		projectPage.clickOnProjectButton();
		projectPage.clickonAllProjectsButton();
		String proName= ExcelUtility.readStringData(1, 0, Constant.PROJECTDATAEXCELFILEPATH, "ProjectDetails")+FakerUtility.getRandomNumber();
		String description=  ExcelUtility.readStringData(1, 1, Constant.PROJECTDATAEXCELFILEPATH, "ProjectDetails");
		projectPage.addProject(proName, 7, description);
		projectPage.searchProject(proName);
		String newTitle= prop.getProperty("newtitle")+FakerUtility.getRandomNumber();
		System.out.println(newTitle);
		projectPage.editProject(newTitle);
		projectPage.searchProject(newTitle);
		System.out.println(projectPage.getProjectCellValue());
		Assert.assertEquals(projectPage.getProjectCellValue(), newTitle);
	}
	
	
	@Test (retryAnalyzer = RetryAnalyzer.class, groups= {"smoke", "regression"})
	public void deleteAProject() throws IOException {
		
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		projectPage.clickOnProjectButton();
		projectPage.clickonAllProjectsButton();
		
		String proName= ExcelUtility.readStringData(1, 0, Constant.PROJECTDATAEXCELFILEPATH, "ProjectDetails")+FakerUtility.getRandomNumber();
		String description=  ExcelUtility.readStringData(1, 1, Constant.PROJECTDATAEXCELFILEPATH, "ProjectDetails");
		
		projectPage.addProject(proName, 7, description);
		
		projectPage.searchProject(proName);
		
		
		projectPage.deleteProject();
		projectPage.searchProject(proName);
		Assert.assertEquals(projectPage.getTextDelete(), "No record found.");
	
	}
	@Test (retryAnalyzer = RetryAnalyzer.class, groups= {"smoke", "regression"})
	public void addANewTask() {
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		projectPage.clickOnProjectButton();
		projectPage.clickOnTasksButton();
		projectPage.clickonAddTaskButton();
		projectPage.addingATask(prop.getProperty("tasktitle"));
		Assert.assertEquals(projectPage.getTextFromTaskCell(), prop.getProperty("tasktitle"));
	}
}
