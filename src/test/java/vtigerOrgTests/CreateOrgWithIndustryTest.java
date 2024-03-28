package vtigerOrgTests;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jline.internal.TestAccessible;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrgPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrgInfoPage;
import vtiger.ObjectRepository.OrgsPage;

public class CreateOrgWithIndustryTest extends BaseClass {
	
	@Test
	public void createOrgWithIndustryTest() throws Throwable {
		
		/* Read data from Excel file */
		String ORGNAME = eUtil.readDataFromExcelFile("Organizations", 4, 2) + jUtil.getRandomNumber();
		String INDUSTRYTYPE = eUtil.readDataFromExcelFile("Organizations", 4, 3);

		// Step3: Navigate to Orgs link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgsLink();

		// Step4: Click on create Org look up img
		OrgsPage op = new OrgsPage(driver);
		op.clickOnCreateOrgLookUpImg();

		// Step5: Create Org with mandatory information
		CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
		cnop.createNewOrg(ORGNAME, INDUSTRYTYPE);

		// Step8: Validate
		OrgInfoPage oip = new OrgInfoPage(driver);
		String orgHeader = oip.getOrgHeader();

		Assert.assertTrue((orgHeader).contains(ORGNAME));
		System.out.println(orgHeader);

	}
	
}
