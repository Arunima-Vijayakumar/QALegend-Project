package TestScripts;

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
	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void addANewProject() throws IOException {
		SoftAssert soft= new SoftAssert();
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		projectPage.clickOnProjectButton();
		projectPage.clickonAllProjectsButton();
		String proName= ExcelUtility.readStringData(1, 0, Constant.PROJECTDATAEXCELFILEPATH, "ProjectDetails")+FakerUtility.getRandomNumber();
		String description=  ExcelUtility.readStringData(1, 1, Constant.PROJECTDATAEXCELFILEPATH, "ProjectDetails");
		String actual= projectPage.getAllprojectsTitle();
		String expected=prop.getProperty("expectedTitleforAllprojects");
	
		projectPage.addProject(proName, 7, description);
		projectPage.searchProject(proName);
		soft.assertEquals(actual, expected);
		soft.assertAll();
	}
	
	
	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void editAProject() throws IOException {
		SoftAssert soft= new SoftAssert();
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		projectPage.clickOnProjectButton();
		projectPage.clickonAllProjectsButton();
		String proName= ExcelUtility.readStringData(1, 0, Constant.PROJECTDATAEXCELFILEPATH, "ProjectName")+FakerUtility.getRandomNumber();
		String description=  ExcelUtility.readStringData(1, 1, Constant.PROJECTDATAEXCELFILEPATH, "ProjectName");
		projectPage.addProject(proName, 7, description);
		String newTitle= prop.getProperty("newtitle")+FakerUtility.getRandomNumber();
		String actual= projectPage.getEditprojectsTitle();
		String expected= prop.getProperty("expectedTitleforEditproject");
		soft.assertEquals(actual, expected);
		soft.assertAll();
		projectPage.editProject(newTitle);
	}
	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void searchAProject() {
		SoftAssert soft= new SoftAssert();
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		projectPage.clickOnProjectButton();
		projectPage.clickonAllProjectsButton();
		String searchtitle= prop.getProperty("searchtitle");
		projectPage.searchProject(searchtitle);
		String actual= projectPage.getProName();
		String expected= searchtitle;
		soft.assertAll();
		
		//projectPage.clickOnSearchedPorject();
	}
	
	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void deleteAProject() {
		SoftAssert soft= new SoftAssert();
		loginPage.logInToQALegend(prop.getProperty("username"), prop.getProperty("password"));
		projectPage.clickOnProjectButton();
		projectPage.clickonAllProjectsButton();
		String searchtitle= prop.getProperty("searchtitle");
		projectPage.searchProject(searchtitle);
		projectPage.deleteProject();
		projectPage.searchProject(searchtitle);
		String actual= projectPage.getTextFromDelete();
		String expected= prop.getProperty("noitemsondelete");
		soft.assertEquals(actual, expected);
		soft.assertAll();
		
	}
}
