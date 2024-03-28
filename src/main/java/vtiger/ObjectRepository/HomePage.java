package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{		//Single Inheritance
	
	//Declaration - dropdowns, frames, windows, textfields, popups
	@FindBy(linkText= "Organizations")
	private WebElement organizationsLink;
	
	@FindBy(linkText= "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText= "Products")
	private WebElement productsLink;
	
	@FindBy(xpath= "//img[@src= 'themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	//@FindBy(linkText= "Sign Out")
	@FindBy(xpath= "//a[text()='Sign Out']")
	private WebElement signOutLink;
	
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization
	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	
	
	//Bussiness Library
	
	/**
	 * This method will mouse hover on admin & logout of application
	 * @param driver
	 * @throws InterruptedException 
	 */
	public void logOutOfApp(WebDriver driver) throws InterruptedException {
		mouseHoverAction(driver, adminImg);
		//Thread.sleep(1000);
		signOutLink.click();
		
	}
	
	/**
	 * This method will click on Organizations link
	 */
	public void clickOnOrgsLink() {
		organizationsLink.click();
	}
	
	/**
	 * This method will click on Contacts link
	 */
	public void clickOnContactsLink() {
		contactsLink.click();
	}
	

}
