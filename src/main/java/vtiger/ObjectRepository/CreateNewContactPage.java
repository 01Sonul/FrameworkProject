package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{

	//Declaration
	@FindBy(name = "lastname")
	private WebElement lastNameEdit;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement orgLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement orgSearchEdit;
	
	@FindBy(name = "search")
	private WebElement orgSearchBtn;
	
	
	//Initialization
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Utilization
	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}


	public WebElement getOrgSearchEdit() {
		return orgSearchEdit;
	}


	public WebElement getOrgSearchBtn() {
		return orgSearchBtn;
	}
	
	//Bussiness Library
	
	public void createNewContact(String LASTNAME) {
		lastNameEdit.sendKeys(LASTNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create Contact using Organization
	 * @param LASTNAME
	 * @param ORGNAME
	 * @param driver
	 */
	public void createNewContact(String LASTNAME, String ORGNAME, WebDriver driver) {
		lastNameEdit.sendKeys(LASTNAME);
		orgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		orgSearchEdit.sendKeys(ORGNAME);
		orgSearchBtn.click();
		
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")); 	//since it's a dynamic element, @FindBy can not find it coz the element'll be created during runtime 
		//driver.findElement(By.linkText(ORGNAME));
		
		switchToWindow(driver, "Contacts");
		saveBtn.click();
		
	}

}
