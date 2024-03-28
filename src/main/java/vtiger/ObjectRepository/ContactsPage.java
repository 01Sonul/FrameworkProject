package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	//Declaration
	@FindBy(xpath = "//img[@title = 'Create Contact...']")
	private WebElement createContactLookUpImg;
	
	//Initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}
	
	//Bussiness Library
	
	/**
	 * This method will click on create contact look up img
	 */
	public void clickOnContactLookUpImg() {
		createContactLookUpImg.click();
		
		
	}
	
	
	
	
	
	
	
	

}
