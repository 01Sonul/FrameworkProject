package vtigerContactTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrgPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrgInfoPage;
import vtiger.ObjectRepository.OrgsPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactWithOrgTest extends BaseClass {

	@Test(groups = "SomeSuite") 	//this group() is used for group execution
	public void createContactWithOrgTest() throws Throwable {
		
		/*Read data from Excel file*/
		String ORGNAME = eUtil.readDataFromExcelFile("Contacts", 4, 2) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 4, 3);

		
		//Step3: Navigate to Orgs link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgsLink();
		Reporter.log("Clicked on org link");
				
		/**
		* preconditions from Step4-Step8
		*/
		//Step4: Click on create Org look up img
		OrgsPage op = new OrgsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		Reporter.log("Clicked on org look up imgage");
				
		//Step5: Create Org with mandatory information
		CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
		cnop.createNewOrg(ORGNAME);
		Reporter.log("Org created");
		
		
		//Step8: Validate
		OrgInfoPage oip = new OrgInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
			
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
		

		//Assert.fail();
		
		//Step9: Click on contact link
		hp.clickOnContactsLink();
		Reporter.log("Clicked on contacts link");
		
		//Step10: Click on create contact look up img
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnContactLookUpImg();
		Reporter.log("Clicked on contact look up image");
		
		//Step11: create contact using the organization
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, ORGNAME, driver);
		Reporter.log("Contact created");
		
		//Step12: Validate for contacts
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
		
	}
	
	
	@Test
	public void demo() {
		System.out.println("demo");
	}
	
	
	
}