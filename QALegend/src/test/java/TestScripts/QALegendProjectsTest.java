package TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import Constants.Constant;
import Utilities.ExcelUtility;
import Utilities.RetryAnalyzer;
import Utilities.WaitUtility;
import net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection;

public class QALegendProjectsTest extends BaseClass{
	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void addANewProject() throws IOException {
		//SoftAssert soft= new SoftAssert();
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		projectPage.clickOnProjectButton();
		projectPage.clickonAllProjectsButton();
		String proName= ExcelUtility.readStringData(1, 0, Constant.PROJECTDATAEXCELFILEPATH, "ProjectDetails");
		String description=  ExcelUtility.readStringData(1, 1, Constant.PROJECTDATAEXCELFILEPATH, "ProjectDetails");
		projectPage.addProject(proName, 7, description);
		
	}
	
	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void editAProject() throws IOException {
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		projectPage.clickOnProjectButton();
		projectPage.clickonAllProjectsButton();
		String proName= ExcelUtility.readStringData(1, 0, Constant.PROJECTDATAEXCELFILEPATH, "ProjectName");
		String description=  ExcelUtility.readStringData(1, 1, Constant.PROJECTDATAEXCELFILEPATH, "ProjectName");
		projectPage.addProject(proName, 7, description);
		String newTitle= prop.getProperty("newtitle");
		projectPage.editProject(newTitle);
	}
	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void searchAProject() {
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		projectPage.clickOnProjectButton();
		projectPage.clickonAllProjectsButton();
		String searchtitle= prop.getProperty("searchtitle");
		projectPage.searchProject(searchtitle);
		projectPage.clickOnSearchedPorject();
		System.out.println(projectPage.getProName());
		
	}
	
	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void deleteAProject() {
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		projectPage.clickOnProjectButton();
		projectPage.clickonAllProjectsButton();
		projectPage.addProject("New Project", 7, "This is a new Project");
		projectPage.searchProject("ESPN");
		projectPage.deleteProject();
	}
}
