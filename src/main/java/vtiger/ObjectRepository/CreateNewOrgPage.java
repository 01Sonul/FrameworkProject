package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrgPage extends WebDriverUtility{

	
	//Declaration
	@FindBy(name = "accountname")
	private WebElement orgNameEdit;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	
	//Initialization
	public CreateNewOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization
	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	//Bussiness Libraries 		//Based on scenarios we can create as many bgness lib as we want
	
	/**
	 * This method will create Org using mandatory fields
	 * @param ORGNAME
	 */
	public void createNewOrg(String ORGNAME) {
		orgNameEdit.sendKeys(ORGNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create Org by handling industry dropdown
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrg(String ORGNAME, String INDUSTRY) {
		orgNameEdit.sendKeys(ORGNAME);
		handleDropdown(industryDropDown, INDUSTRY);
		saveBtn.click();
	}
	
	
	
}
