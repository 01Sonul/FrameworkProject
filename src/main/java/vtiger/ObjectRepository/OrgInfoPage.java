package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {
	
	@FindBy(xpath = "//span[@class = 'dvHeaderText']")
	private WebElement orgHeaderText;
	
	public OrgInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	
	//Business Lib
	/**
	 * This method will return the header text
	 * @return 
	 */
	public String getOrgHeader() {
		return orgHeaderText.getText();
	}
	
	

}
