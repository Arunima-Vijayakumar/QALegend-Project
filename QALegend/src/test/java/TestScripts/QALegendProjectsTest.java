package TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import Utilities.RetryAnalyzer;
import Utilities.WaitUtility;

public class QALegendProjectsTest extends BaseClass{
	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void addANewProject() {
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		projectPage.addProject("New Project", 7, "This is a new Project");
	}
	
	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void editAProject() {
		projectPage.editProject("NewNew Title");
	}
	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void searchAProject() {
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		projectPage.searchProject("ESPN");
	}
	
	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void deleteAProject() {
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		
		projectPage.deleteProject();
	}
}
