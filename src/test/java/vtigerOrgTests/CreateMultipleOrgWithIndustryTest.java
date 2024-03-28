package vtigerOrgTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class CreateMultipleOrgWithIndustryTest extends BaseClass{
	
	@Test(dataProvider = "getData")
	public void createMultipleOrgWithIndustryTest(String ORG, String INDUSTRYTYPE) throws Throwable {
		
		String ORGNAME = ORG+ jUtil.getRandomNumber();
		
		//Step3: Navigate to Orgs link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgsLink();
		
		//Step4: Click on create Org look up img
		OrgsPage op = new OrgsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step5: Create Org with mandatory information
		CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
		cnop.createNewOrg(ORGNAME, INDUSTRYTYPE);
		
		//Step8: Validate
		OrgInfoPage oip = new OrgInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
			
		Assert.assertTrue((orgHeader).contains(ORGNAME));
		System.out.println(orgHeader);
		
	}

	@DataProvider
	public Object[][] getData() throws IOException{	
		Object[][] data = eUtil.readMultipleDataFromExcel("MultipleOrg");
		return data;
		
	}
	
}
