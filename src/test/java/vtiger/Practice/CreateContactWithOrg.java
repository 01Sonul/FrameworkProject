package vtiger.Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrg {
	
public static void main(String[]args) throws InterruptedException {
		
		//Step1: Launch Browser
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		//Step2: Login to App
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step3: Navigate to Contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step4: Click on create Contact look up img
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Step5: Create Contact with mandatory information
		driver.findElement(By.name("lastname")).sendKeys("Travis Kelce");
		
		//Step6: Select Organization name from organization look up image
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		
		//Step7: Switch the control to child window
		String mainWinId = driver.getWindowHandle();
		Set<String> allWinIds = driver.getWindowHandles();
		
		for(String ID: allWinIds) {
			if(!ID.equals(mainWinId)) {
				driver.switchTo().window(ID);
				System.out.println("Window switched to child");
			}
		}
		
		//Step8: Search for organization
		//driver.findElement(By.name("search_text")).sendKeys("Taylor Swift");
		//driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[.='Taylor Swift']")).click();
		
		//Step9: Switching the control back to main window (manually)
		driver.switchTo().window(mainWinId);
		
		//Step10: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step11: Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if((contactHeader).contains("Travis Kelce")) {
			System.out.println("PASS");
			System.out.println(contactHeader);			
		}
		else {
			System.out.println("FAIL");
		}
		
		//Step12: Logout of App
		WebElement mouseHover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		//Step13: Close the browser
		driver.quit();	
	}
}
