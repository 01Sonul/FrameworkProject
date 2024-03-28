package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Rule1: Create a separate pom class for every webpage
	
	
	//Rule2: Identify the web elements using @FindBy, @FindBys, @FindAll
	//Declairation
	@FindBy(name = "user_name")
	private WebElement userNameEdit;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdit; 
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	//Rule3: Create a constructor to initialize the web element
	//Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Rule4: provide getters for accessing the web element
	//Utilization
	public WebElement getUserNameEdit() {
		return userNameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/**
	 * This method will loginto application
	 * we cannot use business lib always
	 * @param USERNAME
	 * @param PASSWORD
	 */
	//Rule5: Provide bussiness library(is the generic method created using web elements present only in current page)
	//Utilization
	public void logIntoApp(String USERNAME, String PASSWORD) {
		userNameEdit.sendKeys(USERNAME);
		passwordEdit.sendKeys(PASSWORD);
		loginBtn.click();
	}

}
