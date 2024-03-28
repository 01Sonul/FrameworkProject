package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of reusable methods related to web driver 
 * so all of the selenium actions will be handled in this perticular class
 *  
 * @author HP
 *
 */
public class WebDriverUtility {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will open the window in fullscreen
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	
	/**
	 * giving implicitly wait
	 * This method will wait for all web elements to load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * giving explicitely wait
	 * This method will wait for 10 secs for perticular element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 *  giving explicitely wait
	 * This method will wait for 10 secs for perticular element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle dropdown using index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will handle the dropdown using value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method will handle the dropdown using visible text
	 * @param element
	 * @param value
	 */
	public void handleDropdown(String text, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method will perform mouse hover action on a web element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();	
	}
	
	/**
	 * This method will perform right click action on a perticular web element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();	
	}
	
	/**
	 * This method will perform double click action on a perticular web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();	
	}
	
	/**
	 * This method will perform drag and drop operation
	 * @param driver
	 * @param scr
	 * @param target
	 */
	public void dragAndDropAction(WebDriver driver, WebElement src, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, target).perform();
	}
	
	/**
	 * This method will move the cursor by offset & click
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void moveTheCursorAndClick(WebDriver driver, int x, int y) {
		Actions a = new Actions(driver);
		a.moveByOffset(x, y).click().perform();
	}
	
	/**
	 * This method will handle frame using index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame using name or ID
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}
	
	/**
	 * This method will handle frame using frame web wlement
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will switch to imidiate parent frame
	 * @param driver
	 * @param index
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch to default frame
	 * @param driver
	 * @param index
	 */
	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will help to switch the control from one window to the other
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		
		//Step1: Capture all the window IDs
		Set<String> allWinIds = driver.getWindowHandles();
		
		//Step2: Navigate through each window
		for(String id: allWinIds) {
			
			//Step3: Switch to each & capture the title
			String actualTitle = driver.switchTo().window(id).getTitle();
			
			//Step4: Compare the title with required
			if(actualTitle.contains(partialWindowTitle)) { 		//true
				break;
			
			}	
		}	
	}
	
	/**
	 * This method will take screenshot & store it in required folder
	 * @param driver
	 * @param screenshotName
	 * @return path
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\ScreenShots\\"+screenshotName+".png");
		Files.copy(src, dest);
		
		return dest.getAbsolutePath(); 		//used for extent reporting
		
	}
	
}
